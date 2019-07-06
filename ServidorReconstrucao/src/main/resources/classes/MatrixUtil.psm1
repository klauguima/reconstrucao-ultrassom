class MatrixUtil {
    [string] testar() {
        return ("aaabb")
    }
}

function Get-MatrixUtil() {
    return [MatrixUtil]::new()
}

Export-ModuleMember -Function Get-MatrixUtil