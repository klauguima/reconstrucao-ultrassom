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
            if($line -ne "" -and $line) {
                $this.hMatrix.Add($line.split(",")) | Out-Null
            }
        }
    }

    [void] readGFile() {
        foreach($line in [System.IO.File]::ReadLines($this.gFilePath)) {
            if($line -ne "" -and $line) {
                $this.gMatrix.Add($line.split(",")) | Out-Null
            }
        }
    }

    [System.Collections.ArrayList] cgne() {
        $matrixUtil = Get-MatrixUtil

        ## Fórmula: r0 = g - Hf0
        [System.Collections.ArrayList]$fMatrix=$matrixUtil.getZeroMatrix($this.hMatrix)
        [System.Collections.ArrayList]$rMatrix=$this.gMatrix
        
        ## Fórmula: p0 = HTr0
        [System.Collections.ArrayList]$pMatrix=$matrixUtil.matrixMultTranpose($this.hMatrix, $rMatrix)
        
        ## Fórmula: riT * ri
		$rtXr = [float]($matrixUtil.matrixMultTranpose($rMatrix, $rMatrix))[0][0];

        $alpha = 0
        $beta = 0
        Write-Verbose -Message "Iniciando convergencia" -Verbose
        for($i = 0; $i -lt 3; $i++) {
            Write-Verbose -Message "parte 1" -Verbose
		    $alpha = $rtXr / [float]($matrixUtil.matrixMultTranpose($pMatrix, $pMatrix))[0][0];# ai = riT * ri / piT * pi
            Write-Verbose -Message "parte 2" -Verbose
		    $fMatrix = $matrixUtil.sum($fMatrix, $matrixUtil.multiplyScalar($pMatrix, $alpha));# fi+1 = fi + ai * pi
            Write-Verbose -Message "parte 3" -Verbose
		    $ri = $matrixUtil.subtract($rMatrix, $matrixUtil.multiply($matrixUtil.multiplyScalar($this.hMatrix, $alpha),$pMatrix));# ri+1 = ri - ai * H * pi
            Write-Verbose -Message "parte 4" -Verbose
		    $ritXri = [float]($matrixUtil.matrixMultTranpose($ri, $ri))[0][0];# =ri+1T * ri+1
            Write-Verbose -Message "parte 5" -Verbose
		    $beta = $ritXri / $rtXr; # Bi = ri+1T * ri+1 / riT * ri
            Write-Verbose -Message "parte 6" -Verbose
		    $pMatrix = $matrixUtil.sum($matrixUtil.matrixMultTranpose($this.hMatrix, $ri), $matrixUtil.multiplyScalar($pMatrix, $beta));# pi = HT * ri+1 + Bi * pi
            Write-Verbose -Message "parte 7" -Verbose
		    $rMatrix = $ri;# ri = ri+1
            Write-Verbose -Message "parte 8" -Verbose
		    $rtXr = $ritXri;

            Write-Verbose -Message $ritXri -Verbose
        }
        #return $matrixUtil.display($alpha);
        return $fMatrix
    }

    [void] createImage([System.Collections.ArrayList]$fmatrix) {
        $imageCreator = Get-ImageCreator $this.outputImagePath
        $imageCreator.createImage($fmatrix)
    }

    [void] main() {
        $this.readGFile()
        Write-Verbose -Message "Arquivo G Lido" -Verbose

        $this.readHFile()
        Write-Verbose -Message "Arquivo H Lido" -Verbose

        [System.Collections.ArrayList]$fmatrix = $this.cgne()
        $this.createImage($fmatrix)
    }

}

function Get-TextToImage([string]$hFilePath, [string]$gFilePath, [string]$outputImagePath) {
    return [TextToImage]::new($hFilePath, $gFilePath, $outputImagePath)
}

Export-ModuleMember -Function Get-TextToImage