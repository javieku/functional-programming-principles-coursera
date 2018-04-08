package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
    * Link to the scaladoc - very clear and detailed tutorial of FunSuite
    *
    * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
    *
    * Operators
    *  - test
    *  - ignore
    *  - pending
    */

  /**
    * Tests are written using the "test" operator and the "assert" method.
    */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
    * For ScalaTest tests, there exists a special equality operator "===" that
    * can be used inside "assert". If the assertion fails, the two values will
    * be printed in the error message. Otherwise, when using "==", the test
    * error message will only say "assertion failed", without showing the values.
    *
    * Try it out! Change the values so that the assertion fails, and look at the
    * error message.
    */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
    * When writing tests, one would often like to re-use certain values for multiple
    * tests. For instance, we would like to create an Int-set and have multiple test
    * about it.
    *
    * Instead of copy-pasting the code for creating the set into every test, we can
    * store it in the test class using a val:
    *
    * val s1 = singletonSet(1)
    *
    * However, what happens if the method "singletonSet" has a bug and crashes? Then
    * the test methods are not even executed, because creating an instance of the
    * test class fails!
    *
    * Therefore, we put the shared values into a separate trait (traits are like
    * abstract classes), and create an instance inside each test method.
    *
    */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "singletonSet" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "singletonSet", exchange the
    * function "ignore" by "test".
    */
  test("singletonSet(1) contains 1") {

    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union contains 1")
      assert(contains(s, 2), "Union contains 2")
      assert(!contains(s, 3), "Union does not contain 3")
    }
  }

  test("intersection should be false for disjoint sets") {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "Intersect does not contain 1")
      assert(!contains(s, 2), "Intersect does not contain 2")
      assert(!contains(s, 3), "Intersect does not contain 3")
    }
  }

  test("intersection should be true for common values") {
    new TestSets {
      val s = intersect(s1, union(s1, s2))
      assert(contains(s, 1), "Intersect contains common value 1")
      assert(!contains(s, 2), "Intersect does not contain 2")
      assert(!contains(s, 3), "Intersect does not contain 3")
    }
  }

  test("forall should find value") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x > 0 && x < 4 ), "forall range test")
      assert(!forall(s, x => x == 2), "forall not all values are 2")
    }
  }

  test("map should apply function to every element") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val sSquared = map(s, x => x * x);
      assert(contains(sSquared, 1), "square of 1 is 1")
      assert(contains(sSquared, 4), "square of 2 is 4")
      assert(contains(sSquared, 9), "square of 3 is 9")
    }
  }

  test("exists & filter: even and 3") {
    new TestSets {
      val set = (x:Int) => x%2 == 0 || x == 3
      assert(exists(set, x => x==3), "contains 3")
    }
  }


  /*
  *
  * [Test Description] map: {1,3,4,5,7,1000}
[Observed Error] "{0,2,3,4,6[]}" did not equal "{0,2,3,4,6[,999]}"
[Lost Points] 10

[Test Description] exists & filter: even and 3
[Observed Error] FunSets.exists($anon.this.evenAnd3, ((x$12: Int) => x$12.%(2).==(1))) was false The set of all even numbers and 3 should contain an odd element, namely 3.
[Lost Points] 10

[Test Description] exists: given {1,2,3,4}
[Observed Error] FunSets.exists($anon.this.s2, ((x$10: Int) => x$10.==(2))) was false 2 should exist in the given set.
[Lost Points] 10
  *
  * */

}
