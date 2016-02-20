/**
  * Created by snowp on 19/02/2016.
  */
object testBenchmark {
  def validateRows(a: Array[Array[String]], colSize: Integer):Unit={
     a.view.zipWithIndex.foreach((row)=>{
      if (row._1.length != colSize)
        println("row  " + row._2 + "has "+ row._1.length +" but expected" + colSize)
      else
        row._1.view.zipWithIndex.foreach((col)=>{
          try {
            col._1.toLong
          } catch {
            case e: Exception => println("Err at (" + col._2+ ", " + row._2 + "): "+ e.getMessage)
          }

        })
    })
  }

def validateRow(a: Array[String], colSize: Integer):Unit={
      if (a.length != colSize)
        println("row  has "+ a.length +" but expected" + colSize)
      else
        a.view.zipWithIndex.foreach((col)=>{
          try {
            col._1.toLong
          } catch {
            case e: Exception => println("Err at (" + col._2+ ", ): "+ e.getMessage)
          }

        })
    
  }
	def time[A](a: => A) = {
		val now = System.currentTimeMillis
		val result = a
		val micros = (System.currentTimeMillis - now)
		println(micros)
	}

  def main(args: Array[String]) {
	
	///val lines = scala.io.Source.fromFile(args(0)).getLines	

	var a = Array.ofDim[String](args(1).toInt, args(0).toInt)
/*
//	lines.foreach((row) => {
//		a = a :+ row.split(",")
//	} )
	var i = 0
	var j = 0
	while (lines.hasNext) {
       		j=0
		val iterator = lines.next().split(",").iterator
		while(iterator.hasNext){
            		a(i)(j) = iterator.next()
			j = j+1 
		}

         	i = i + 1
      	}	

*/
	var i=0
val now = System.currentTimeMillis
	println(now)

    	for (ln <- io.Source.stdin.getLines){
		//a(i)=ln.split(",")
val lin = ln.split(",")
		validateRow(lin, ln.length)
		i = i + 1	
	}	 
	//println(ln)
	
//	val now = System.currentTimeMillis
//	println(now)

        //validateRows(a, a(0).length)

	println(System.currentTimeMillis)

	val micros = (System.currentTimeMillis - now)
	println(micros)

  }
}
