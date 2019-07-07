class MatrixUtil {
    [System.Collections.ArrayList] multiply([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult=@{}
        
		$numColumnsA = $matrixA[0].Count
        $numRowsA = $matrixA.Count
        
		$numColumnsB = $matrixB[0].Count
        $numRowsB = $matrixB.Count
        
        if ($numColumnsA -ne $numRowsB) {
            throw "As matrixes não podem ser multiplicadas"
        } else {
            $sum = 0
            for ($c=0; $c -lt $numRowsA; $c++) {
                for ($d=0; $d -lt $numColumnsB; $d++) {
                    for ($k=0; $k -lt $numRowsB; $k++) {
						$sum = $sum + $matrixA[$c][$k] * $matrixB[$k][$d];
                    }
                }
            }
        }

        return ($matrixResult)
    }
}

function Get-MatrixUtil() {
    return [MatrixUtil]::new()
}

Export-ModuleMember -Function Get-MatrixUtil