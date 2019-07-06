[System.Reflection.Assembly]::LoadWithPartialName("System.Drawing")
$bmp = New-Object System.Drawing.Bitmap(320, 240)

for ($i = 0; $i -lt 200; $i++)
{
   for ($j = 0; $j -lt 100; $j++)
   {
     $bmp.SetPixel($i, $j, [System.Drawing.Color]::FromArgb(100, 100, 100))
   }
}

$bmp.Save("C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\Img1.bmp")