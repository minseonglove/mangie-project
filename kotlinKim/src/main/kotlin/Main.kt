val arr = arrayOf(arrayOf(1L,1L), arrayOf(1L,0L))
const val mod = 1000000007L
fun main(){
    val n = readLine()!!.toLong()
    println(pow(arr, n-1L)[0][0])
}

fun pow(start: Array<Array<Long>>, n: Long):Array<Array<Long>>{
    if(n <= 1)
        return start
    var result = pow(start, n / 2)
    result = multi(result, result)
    if(n % 2 == 1L)
        result = multi(result, arr)
    return result
}

fun multi(arr1: Array<Array<Long>>, arr2: Array<Array<Long>>): Array<Array<Long>>{
    val result = Array(2) { Array(2) {0L} }
    for (k in 0 until 2) {
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                result[i][j] += arr1[i][k] * arr2[k][j];
                result[i][j] %= mod;
            }
        }
    }
    return result
}