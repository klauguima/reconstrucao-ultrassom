class MatrixUtil {
    [System.Collections.ArrayList] multiply([System.Collections.ArrayList]$matrixA, [System.Collections.ArrayList]$matrixB) {
        [System.Collections.ArrayList]$matrixResult=@{}
        
		$numColumnsA = $matrixA[0].Count;
        $numRowsA = $matrixA.Count
        
		$numColumnsB = $matrixB[0].Count;
        $numRowsB = $matrixB.Count
        
        throw "As matrixes não podem ser multiplicadas"
        if ($numColumnsA -ne $numRowsB) {
            throw "As matrixes não podem ser multiplicadas"
        } else {
            
        }

        return ($matrixResult)
    }
}

function Get-MatrixUtil() {
    return [MatrixUtil]::new()
}

Export-ModuleMember -Function Get-MatrixUtil