class ImageCreator {
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
        
        [System.Reflection.Assembly]::LoadWithPartialName("System.Drawing")
        $bmp = New-Object System.Drawing.Bitmap(320, 240)
        for ($i = 0; $i -lt 100; $i++) {
           for ($j = 0; $j -lt 100; $j++) {
             $bmp.SetPixel($i, $j, [System.Drawing.Color]::FromArgb(0, 100, 200))
           }
        }
        $bmp.Save("C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\img1.bmp")
    }
}

function Get-ImageCreator() {
    return [ImageCreator]::new()
}

Export-ModuleMember -Function Get-ImageCreator