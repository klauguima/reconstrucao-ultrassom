class TextToImage {
    ## ATRIBUTES
    [string]$hFilePath
    [string]$gFilePath
    [System.Collections.ArrayList]$gMatrix=@{}
    [System.Collections.ArrayList]$hMatrix=@{}
    

    ## CONSTRUCTOR
    TextToImage([string]$hFilePath, [string]$gFilePath) {
        $this.hFilePath = $hFilePath
        $this.gFilePath = $gFilePath
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

    [void] cgne() {
        [System.Collections.ArrayList]$fMatrix=@{}

        foreach($line in $this.hMatrix[0]) {
            [System.Collections.ArrayList]$zeroArray=@{}
            $zeroArray.Add(0) | Out-Null
            $fMatrix.Add($zeroArray) | Out-Null
        }

        $matrixUtil = Get-MatrixUtil
        [System.Collections.ArrayList]$resultMatrix=$matrixUtil.multiply($this.hMatrix, $fMatrix)

    }

    [void] main() {
        $this.readGFile()
        $this.readHFile()
        $this.cgne()
    }
}

function Get-TextToImage([string]$hFilePath, [string]$gFilePath) {
    return [TextToImage]::new($hFilePath, $gFilePath)
}

Export-ModuleMember -Function Get-TextToImage