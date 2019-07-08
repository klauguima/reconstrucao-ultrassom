class ImageCreator {
    [string]$outputImagePath
    
    ImageCreator([string]$outputImagePath) {
        $this.outputImagePath = $outputImagePath
    }

    [void] createImage([System.Collections.ArrayList]$matrix) {
        $min = [float]$matrix[0][0]
        $max = [float]$matrix[0][0]

        foreach($line in $matrix) {
			if ([float]$line[0] -gt $max) {
				$max = [float]$line[0];
			}
			if ([float]$line[0] -lt $min) {
				$min = [float]$line[0];
			}
        }
        
        $k = 0
        [System.Reflection.Assembly]::LoadWithPartialName("System.Drawing")
        $bmp = New-Object System.Drawing.Bitmap(320, 240)
        for ($i = 0; $i -lt 60; $i++) {
           for ($j = 0; $j -lt 60; $j++) {
           	 $value = [int] ((255 / ($max - $min)) * ($matrix[$k][0] - $min));
             $bmp.SetPixel($i, $j, [System.Drawing.Color]::FromArgb($value, $value, $value))
             $k++
           }
        }
        $bmp.Save($this.outputImagePath)
    }
}

function Get-ImageCreator([string] $outputImagePath) {
    return [ImageCreator]::new($outputImagePath)
}

Export-ModuleMember -Function Get-ImageCreator