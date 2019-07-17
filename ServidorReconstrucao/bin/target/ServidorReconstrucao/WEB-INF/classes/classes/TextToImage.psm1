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

    [string] cgne() {
        $matrixUtil = Get-MatrixUtil

        ## Fórmula: r0 = g - Hf0
        [System.Collections.ArrayList]$fMatrix=$matrixUtil.getZeroMatrix($this.hMatrix)
        [System.Collections.ArrayList]$resultMatrix=$matrixUtil.subtract($this.gMatrix, $fMatrix)

        return $matrixUtil.display($resultMatrix);
    }

    [void] main() {
        $this.readGFile()
        #$this.readHFile()
        #return $this.cgne()

        $imageCreator = Get-ImageCreator $this.outputImagePath
        $imageCreator.createImage($this.gMatrix)
    }
}

function Get-TextToImage([string]$hFilePath, [string]$gFilePath, [string]$outputImagePath) {
    return [TextToImage]::new($hFilePath, $gFilePath, $outputImagePath)
}

Export-ModuleMember -Function Get-TextToImage