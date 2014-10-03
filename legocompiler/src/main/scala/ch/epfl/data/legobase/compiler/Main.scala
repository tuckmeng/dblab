package ch.epfl.data
package legobase
package compiler

import deep._
import prettyprinter._
import optimization._
import pardis.optimization._
import pardis.ir._
import pardis.types.PardisTypeImplicits._

object Main extends LegoRunner {

  def main(args: Array[String]) {
    if (args.length < 3) {
      System.out.println("ERROR: Invalid number (" + args.length + ") of command line arguments!")
      System.out.println("USAGE: run <data_folder> <scaling_factor_number> <list of queries to run> <copy>?")
      System.out.println("     : data_folder_name should contain folders named sf0.1 sf1 sf2 sf4 etc")
      System.exit(0)
    }
    Config.checkResults = false

    run(args)
  }

  /* For the moment this transformation is only valid for C code generation */
  val hashMapToArray = true

  def executeQuery(query: String): Unit = {
    val context = new LoweringLegoBase {}
    import context._
    query match {
      case "Q1"    => compileQuery(context, reifyBlock { Queries.Q1(unit(Config.numRuns)) }, 1, false, false)
      case "Q1_C"  => compileQuery(context, reifyBlock { Queries.Q1(unit(Config.numRuns)) }, 1, false, true)
      case "Q2"    => compileQuery(context, reifyBlock { Queries.Q2(unit(Config.numRuns)) }, 2, false, false)
      case "Q2_C"  => compileQuery(context, reifyBlock { Queries.Q2(unit(Config.numRuns)) }, 2, false, true)
      case "Q3"    => compileQuery(context, reifyBlock { Queries.Q3(unit(Config.numRuns)) }, 3, false, false)
      case "Q3_C"  => compileQuery(context, reifyBlock { Queries.Q3(unit(Config.numRuns)) }, 3, false, true)
      case "Q4"    => compileQuery(context, reifyBlock { Queries.Q4(unit(Config.numRuns)) }, 4, false, false)
      case "Q4_C"  => compileQuery(context, reifyBlock { Queries.Q4(unit(Config.numRuns)) }, 4, false, true)
      case "Q5"    => compileQuery(context, reifyBlock { Queries.Q5(unit(Config.numRuns)) }, 5, false, false)
      case "Q5_C"  => compileQuery(context, reifyBlock { Queries.Q5(unit(Config.numRuns)) }, 5, false, true)
      case "Q6"    => compileQuery(context, reifyBlock { Queries.Q6(unit(Config.numRuns)) }, 6, false, false)
      case "Q6_C"  => compileQuery(context, reifyBlock { Queries.Q6(unit(Config.numRuns)) }, 6, false, true)
      case "Q7"    => compileQuery(context, reifyBlock { Queries.Q7(unit(Config.numRuns)) }, 7, false, false)
      case "Q7_C"  => compileQuery(context, reifyBlock { Queries.Q7(unit(Config.numRuns)) }, 7, false, true)
      case "Q8"    => compileQuery(context, reifyBlock { Queries.Q8(unit(Config.numRuns)) }, 8, false, false)
      case "Q8_C"  => compileQuery(context, reifyBlock { Queries.Q8(unit(Config.numRuns)) }, 8, false, true)
      case "Q9"    => compileQuery(context, reifyBlock { Queries.Q9(unit(Config.numRuns)) }, 9, false, false)
      case "Q9_C"  => compileQuery(context, reifyBlock { Queries.Q9(unit(Config.numRuns)) }, 9, false, true)
      case "Q10"   => compileQuery(context, reifyBlock { Queries.Q10(unit(Config.numRuns)) }, 10, false, false)
      case "Q10_C" => compileQuery(context, reifyBlock { Queries.Q10(unit(Config.numRuns)) }, 10, false, true)
      case "Q11"   => compileQuery(context, reifyBlock { Queries.Q11(unit(Config.numRuns)) }, 11, false, false)
      case "Q11_C" => compileQuery(context, reifyBlock { Queries.Q11(unit(Config.numRuns)) }, 11, false, true)
      case "Q12"   => compileQuery(context, reifyBlock { Queries.Q12(unit(Config.numRuns)) }, 12, false, false)
      case "Q12_C" => compileQuery(context, reifyBlock { Queries.Q12(unit(Config.numRuns)) }, 12, false, true)
      case "Q13"   => compileQuery(context, reifyBlock { Queries.Q13(unit(Config.numRuns)) }, 13, false, false)
      case "Q13_C" => compileQuery(context, reifyBlock { Queries.Q13(unit(Config.numRuns)) }, 13, false, true)
      case "Q14"   => compileQuery(context, reifyBlock { Queries.Q14(unit(Config.numRuns)) }, 14, false, false)
      case "Q14_C" => compileQuery(context, reifyBlock { Queries.Q14(unit(Config.numRuns)) }, 14, false, true)
      case "Q15"   => compileQuery(context, reifyBlock { Queries.Q15(unit(Config.numRuns)) }, 15, false, false)
      case "Q15_C" => compileQuery(context, reifyBlock { Queries.Q15(unit(Config.numRuns)) }, 15, false, true)
      case "Q16"   => compileQuery(context, reifyBlock { Queries.Q16(unit(Config.numRuns)) }, 16, false, false)
      case "Q16_C" => compileQuery(context, reifyBlock { Queries.Q16(unit(Config.numRuns)) }, 16, false, true)
      case "Q17"   => compileQuery(context, reifyBlock { Queries.Q17(unit(Config.numRuns)) }, 17, false, false)
      case "Q17_C" => compileQuery(context, reifyBlock { Queries.Q17(unit(Config.numRuns)) }, 17, false, true)
      case "Q18"   => compileQuery(context, reifyBlock { Queries.Q18(unit(Config.numRuns)) }, 18, false, false)
      case "Q18_C" => compileQuery(context, reifyBlock { Queries.Q18(unit(Config.numRuns)) }, 18, false, true)
      case "Q19"   => compileQuery(context, reifyBlock { Queries.Q19(unit(Config.numRuns)) }, 19, false, false)
      case "Q19_C" => compileQuery(context, reifyBlock { Queries.Q19(unit(Config.numRuns)) }, 19, false, true)
      case "Q20"   => compileQuery(context, reifyBlock { Queries.Q20(unit(Config.numRuns)) }, 20, false, false)
      case "Q20_C" => compileQuery(context, reifyBlock { Queries.Q20(unit(Config.numRuns)) }, 20, false, true)
      case "Q21"   => compileQuery(context, reifyBlock { Queries.Q21(unit(Config.numRuns)) }, 21, false, false)
      case "Q21_C" => compileQuery(context, reifyBlock { Queries.Q21(unit(Config.numRuns)) }, 21, false, true)
      case "Q22"   => compileQuery(context, reifyBlock { Queries.Q22(unit(Config.numRuns)) }, 22, false, false)
      case "Q22_C" => compileQuery(context, reifyBlock { Queries.Q22(unit(Config.numRuns)) }, 22, false, true)
    }
  }

  def compileQuery(context: LoweringLegoBase, block: pardis.ir.PardisBlock[Unit], number: Int, shallow: Boolean, generateCCode: Boolean) {
    def writeASTToDumpFile(b0: pardis.ir.PardisBlock[Unit]) {
      val pw = new java.io.PrintWriter(new java.io.File("tree_debug_dump.txt"))
      pw.println(b0.toString)
      pw.flush()
    }

    // Lowering (e.g. case classes to records)
    val loweredBlock = {
      if (shallow) block
      else {
        val lowering = new LBLowering(context, context, generateCCode)
        val loweredBlock0 = lowering.lower(block)
        val parameterPromotion = new LBParameterPromotion(context)
        parameterPromotion.optimize(loweredBlock0)
      }
    }

    val afterHashMapToArray = {
      if (hashMapToArray && generateCCode) {
        val hmHoist = new HashMapHoist(context)
        val hm2Arr = new HashMapToArrayTransformer(context)
        val afterPE = new PartialyEvaluate(context).optimize(new DCE(context).optimize(loweredBlock))
        //writeASTToDumpFile(afterPE)
        val hmBlock = hm2Arr.optimize(hmHoist.optimize(afterPE))
        hmBlock
      } else {
        loweredBlock
      }
    }

    writeASTToDumpFile(afterHashMapToArray)

    // DCE
    val dce = new DCE(context)
    val dceBlock = dce.optimize(afterHashMapToArray)

    // Partial evaluation
    //val partiallyEvaluator = new PartialyEvaluate(context)
    //val partiallyEvaluatedBlock = partiallyEvaluator.optimize(dceBlock)
    val partiallyEvaluatedBlock = dceBlock

    // Convert Scala constructs to C
    val finalBlock = {
      if (generateCCode) {
        // Note this is DCE block because some optimziations break with partially evaluated
        val cBlock = CTransformersPipeline(context, dceBlock)
        val dceC = new DCECLang(context)
        dceC.optimize(cBlock)
      } else partiallyEvaluatedBlock
    }

    // System.out.println(finalBlock)
    // Generate final program 
    val ir2Program = new { val IR = context } with IRToProgram {}
    val finalProgram = ir2Program.createProgram(finalBlock)
    if (generateCCode) (new LegoCGenerator(shallow, "Q" + number, false)).apply(finalProgram)
    else (new LegoScalaGenerator(shallow, "Q" + number)).apply(finalProgram)
  }
}
