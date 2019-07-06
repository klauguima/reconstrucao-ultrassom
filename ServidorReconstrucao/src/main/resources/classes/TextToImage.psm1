class TextToImage {
    ## ATRIBUTES
    [string]$hFilePath
    [string]$gFilePath
    [System.Collections.ArrayList]$arrValuesG=@{}
    [System.Collections.ArrayList]$arrValuesH=@{}

    ## CONSTRUCTOR
    TextToImage([string]$hFilePath, [string]$gFilePath) {
        $this.hFilePath = $hFilePath
        $this.gFilePath = $gFilePath
    }

    ## FUNCTIONS
    [void] readHFile() {
        foreach($line in [System.IO.File]::ReadLines($this.hFilePath)) {
            $this.arrValuesH.Add($line.split(",")) | Out-Null
        }
    }

    [void] readGFile() {
        foreach($line in [System.IO.File]::ReadLines($this.gFilePath)) {
            $this.arrValuesG.Add($line.split(",")) | Out-Null
        }
    }

    [void] cgne() {
        [System.Collections.ArrayList]$fMatrix=@{}

        foreach($line in $this.arrValuesG) {
            [System.Collections.ArrayList]$zeroArray=@{}
            $zeroArray.Add(0) | Out-Null
            $fMatrix.Add($zeroArray) | Out-Null
        }
    }

    [void] main() {
        readGFile
        readHFile
        #cgne
    }
}

function Get-TextToImage([string]$hFilePath, [string]$gFilePath) {
    return [TextToImage]::new([string]$hFilePath, [string]$gFilePath)
}

Export-ModuleMember -Function Get-TextToImage