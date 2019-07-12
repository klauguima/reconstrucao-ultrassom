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
                $matrixResult.Add([System.Collections.ArrayList]@{})

                for ($d=0; $d -lt $numColumnsB; $d++) {
                    for ($k=0; $k -lt $numRowsB; $k++) {
						$sum = $sum + [float]$matrixA[$c][$k] * [float]$matrixB[$k][$d];
                    }
					$matrixResult[$c].Add($sum);
					$sum = [float]0;
                }
            }
        }

        return ($matrixResult)
    }

    [System.Collections.ArrayList] multiplyScalar([System.Collections.ArrayList]$matrixA, [float]$scalarValue) {
        [System.Collections.ArrayList]$matrixResult = @{}
        
		$numColumnsA = $matrixA[0].Count
        $numRowsA = $matrixA.Count
                
        for ($i=0; $i -lt $numRowsA; $i++) {
            for ($j=0; $j -lt $numColumnsA; $j++) {
				$total = [float]$matrixA[$i][$j] * $scalarValue;

                if($matrixResult.Count -le $i) {
                    $matrixResult.Add([System.Collections.ArrayList]@{})
                }
				$matrixResult[$i].Add($total)
            }
        }
        return ($matrixResult)
    }

    [System.Collections.ArrayList] subtract([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult = @{}
        
		$numColumnsA = $matrixA[0].Count
        $numRowsA = $matrixA.Count
        
		$numColumnsB = $matrixB[0].Count
        $numRowsB = $matrixB.Count
        
        for ($i=0; $i -lt $numRowsA; $i++) {
            for ($j=0; $j -lt $numColumnsA; $j++) {
                $total = 0
				if ($numRowsB -gt $i -and $numColumnsB -gt $j) {
					$total = [float]$matrixA[$i][$j] - [float]$matrixB[$i][$j];
                } else {
                    $total = [float]$matrixA[$i][$j]
                }
                
                if($matrixResult.Count -le $i) {
                    $matrixResult.Add([System.Collections.ArrayList]@{})
                }
				$matrixResult[$i].Add($total)
            }
        }
        return ($matrixResult)
    }
    

    [System.Collections.ArrayList] sum([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult = @{}
        
		$numColumnsA = $matrixA[0].Count
        $numRowsA = $matrixA.Count
        
		$numColumnsB = $matrixB[0].Count
        $numRowsB = $matrixB.Count
        
        for ($i=0; $i -lt $numRowsA; $i++) {
            for ($j=0; $j -lt $numColumnsA; $j++) {
                $total = 0
				if ($numRowsB -gt $i -and $numColumnsB -gt $j) {
					$total = [float]$matrixA[$i][$j] + [float]$matrixB[$i][$j];
                } else {
                    $total = [float]$matrixA[$i][$j]
                }
                
                if($matrixResult.Count -le $i) {
                    $matrixResult.Add([System.Collections.ArrayList]@{})
                }
				$matrixResult[$i].Add($total)
            }
        }
        return ($matrixResult)
    }
    
    [System.Collections.ArrayList] matrixMultTranpose([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult = @{}
        
		$col = $matrixB[0].Count
		$row = $matrixA[0].Count
		$rowsCountA = $matrixA.Count
        
        for ($i=0; $i -lt $row; $i++) {
            $matrixResult.Add([System.Collections.ArrayList]@{})

            for ($j=0; $j -lt $col; $j++) {
				$sum = [float]0;
                for ($k=0; $k -lt $rowsCountA; $k++) {
					$sum = $sum + [float]$matrixA[$k][$i] * [float]$matrixB[$k][$j];
                }
				$matrixResult[$i].Add($sum);
            }
        }

        return ($matrixResult)
    }
    
    [System.Collections.ArrayList] transpose([System.Collections.ArrayList]$matrix) {
        [System.Collections.ArrayList]$matrixResult = @{}
                
        for ($i=0; $i -lt $matrix.Count; $i++) {
            for ($j=0; $j -lt $matrix[0].Count; $j++) {
                if($matrixResult.Count -le $j) {
                    $matrixResult.Add([System.Collections.ArrayList]@{})
                }
				$matrixResult[$j].Add($matrix[$i][$j]);
            }
        }

        return ($matrixResult)
    }

    [System.Collections.ArrayList] getZeroMatrix([System.Collections.ArrayList]$matrix) {
        [System.Collections.ArrayList]$zeroMatrix = @{}

        foreach($line in $matrix) {
            [System.Collections.ArrayList]$zeroLine = @{}
            $zeroLine.Add(0);
            $zeroMatrix.Add($zeroLine);
        }
        return $zeroMatrix
    }

    [string] display([System.Collections.ArrayList]$matrix) {
        $retorno = ""

        foreach($line in $matrix) {
            foreach($column in $line) {
                $retorno = $retorno + $column + "`t"
            }
            $retorno = $retorno + "`n"
        }
        
        return $retorno
    }
}

function Get-MatrixUtil() {
    return [MatrixUtil]::new()
}

Export-ModuleMember -Function Get-MatrixUtil