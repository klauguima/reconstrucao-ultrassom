class TextToImage {
    ## ATRIBUTES
    [string]$hFilePath
    [string]$gFilePath
    [string]$outputImagePath
    [System.Collections.ArrayList]$gMatrix=@{}
    [System.Collections.ArrayList]$hMatrix=@{}
    

    ## CONSTRUCTOR
    TextToImage([string]$hFilePath, [string]$gFilePath, [string] $outputImagePath) {
        $this.hFilePath = $hFilePath
        $this.gFilePath = $gFilePath
        $this.outputImagePath = $outputImagePath
    }

    ## FUNCTIONS
    [void] readHFile() {
        foreach($line in [System.IO.File]::ReadLines($this.hFilePath)) {
            $this.hMatrix.Add($line.split(",")) | Out-Null
        }
    }

    [void] readGFile() {
        foreach($line in [System.IO.File]::ReadLines($this.gFilePath)) {
            $this.gMatrix.Add($line.split(",")) | Out-Null
        }
    }

    [System.Collections.ArrayList] cgne() {
    #[string] cgne() {
        $matrixUtil = Get-MatrixUtil

        ## Fórmula: r0 = g - Hf0
        [System.Collections.ArrayList]$fMatrix=$matrixUtil.getZeroMatrix($this.hMatrix)
        [System.Collections.ArrayList]$resultMatrix=$matrixUtil.subtract($this.gMatrix, $fMatrix)
        
        ## Fórmula: p0 = HTr0
        [System.Collections.ArrayList]$pMatrix=$matrixUtil.matrixMultTranpose($this.hMatrix, $resultMatrix)
        
        ## Fórmula: riT * ri
		$rtXr = [float]($matrixUtil.multiply($matrixUtil.transpose($resultMatrix), $resultMatrix))[0][0];

        [System.Collections.ArrayList]$riMatrix=@{}

        $alpha = 0
        $beta = 0
        for($i = 0; $i -lt 15; $i++) {
		    $alpha = $rtXr / [float]($matrixUtil.multiply($matrixUtil.transpose($pMatrix), $pMatrix))[0][0];# ai = riT * ri / piT * pi
		    $fMatrix = $matrixUtil.sum($fMatrix, $matrixUtil.multiplyScalar($pMatrix, $alpha));# fi+1 = fi + ai * pi
		    $ri = $matrixUtil.subtract($resultMatrix, $matrixUtil.multiplyScalar($matrixUtil.multiply($this.hMatrix, $pMatrix), $alpha));# ri+1 = ri - ai * H * pi
		    $ritXri = [float]($matrixUtil.multiply($matrixUtil.transpose($ri), $ri))[0][0];# =ri+1T * ri+1
		    $beta = $ritXri / $rtXr; # Bi = ri+1T * ri+1 / riT * ri
		    $pMatrix = $matrixUtil.sum($matrixUtil.matrixMultTranpose($this.hMatrix, $ri), $matrixUtil.multiplyScalar($pMatrix, $beta));# pi = HT * ri+1 + Bi * pi
		    $resultMatrix = $ri;# ri = ri+1
		    $rtXr = $ritXri;
        }
        #return $matrixUtil.display($alpha);
        #$this.createImage($fmatrix)
        #return $matrixUtil.display($fMatrix);
        return $fMatrix
    }

    [void] createImage([System.Collections.ArrayList]$fmatrix) {
        $imageCreator = Get-ImageCreator $this.outputImagePath
        $imageCreator.createImage($fmatrix)
    }

    [void] main() {
        $this.readGFile()
        $this.readHFile()
        #return $this.cgne()
        [System.Collections.ArrayList]$fmatrix = $this.cgne()
        $this.createImage($fmatrix)
    }

}

function Get-TextToImage([string]$hFilePath, [string]$gFilePath, [string]$outputImagePath) {
    return [TextToImage]::new($hFilePath, $gFilePath, $outputImagePath)
}

Export-ModuleMember -Function Get-TextToImage