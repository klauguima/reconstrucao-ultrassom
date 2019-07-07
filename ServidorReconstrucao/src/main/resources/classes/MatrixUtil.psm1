class MatrixUtil {
    [System.Collections.ArrayList] multiply([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult = @{}
        
		$numColumnsA = $matrixA[0].Count
        $numRowsA = $matrixA.Count
        
		$numColumnsB = $matrixB[0].Count
        $numRowsB = $matrixB.Count
        
        if ($numColumnsA -ne $numRowsB) {
            throw "As matrixes não podem ser multiplicadas"
        } else {
            $sum = [float]0
            for ($c=0; $c -lt $numRowsA; $c++) {
                $matrixResult.Add(@{})
                for ($d=0; $d -lt $numColumnsB; $d++) {
                    for ($k=0; $k -lt $numRowsB; $k++) {
						$sum = $sum + [float]$matrixA[$c][$k] * [float]$matrixB[$k][$d];
                    }
					$matrixResult[$c][$d] = $sum;
					$sum = [float]0;
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