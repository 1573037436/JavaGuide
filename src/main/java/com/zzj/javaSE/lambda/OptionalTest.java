package com.zzj.javaSE.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.zzj.javaSE.model.Employee;
/**
 * isPresent()
 * of(String name)
 * orElse(String name)
 * orElseGet(Supplier<? extends String> other)
 * get() 当值不存在时，它会抛出一个NoSuchElementException异常
 * filter(Predicate<? super Integer> predicate)
 * map(Function<? super List<String>, ? extends Integer> mapper)
 * flatMap(Function<? super Employee, Optional<String>> mapper)
 * @author zzj
 * @date 2020年1月10日
 */
public class OptionalTest {
	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		//创建一个空的Optional对象
	    Optional<String> empty = Optional.empty();
	    //判断对象是否为空
	    assertFalse(empty.isPresent());
	}

	@Test
	public void givenNonNull_whenCreatesOptional_thenCorrect() {
	    //传递给of()的值不可以为空，否则会抛出空指针异常
	    String name ="baeldung";
	    Optional<String> opt = Optional.of(name);
	    assertEquals("Optional[baeldung]", opt.toString());
	    //String name =null;
	    //需要传递一些空值时使用ofNullable;
	    //Optional<String> optNull = Optional.ofNullable(name);
	    //assertEquals("Optional.empty", optNull.toString());
	}
	//orEse && orElseGet
	@Test
	public void whenOrElseWorks_thenCorrect() {
	    String nullName = null;
	    //检索Optional对象中的值，它被传入一个"默认参数"。如果对象中存在一个值，则返回它，否则返回传入的“默认参数”
	    String name = Optional.ofNullable(nullName).orElse("john");
	    assertEquals("john", name);
	}
	//与orElse类似，但是这个函数不接收一个“默认参数”，而是一个函数接口
	@Test
	public void whenOrElseGetWorks_thenCorrect() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
	    assertEquals("john", name);
	}
	//使用get() API 也可以返回被包裹着的值。但是必须是值存在时，当值不存在时，它会抛出一个NoSuchElementException异常
	//因为这个方法与我们使用Optional的目的相违背，所以可以预见在不久将来它或许会被抛弃，建议还是使用其他的方法。
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
	    Optional<String> opt = Optional.of("baeldung");
	    String name = opt.get();
	 
	    assertEquals("baeldung", name);
	}
	//filter()接收一个函数式接口，当符合接口时，则返回一个Optional对象，否则返回一个空的Optional对象。
	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
	    assertTrue(is2016);
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    assertFalse(is2017);
	}
	//map()我们可以将一个值转换为另一个值
	@Test
	public void givenOptional_whenMapWorks_thenCorrect() {
	    List<String> companyNames = Arrays.asList(
	      "paypal", "oracle", "", "microsoft", "", "apple");
	    Optional<List<String>> listOptional = Optional.of(companyNames);
	    int size = listOptional
	      .map(List::size)
	      .orElse(0);
	    assertEquals(6, size);
	}
	@Test
	public void givenOptional_whenMapWorks_thenCorrect2() {
	    String name = "baeldung";
	    Optional<String> nameOptional = Optional.of(name);
	 
	    int len = nameOptional
	     .map(String::length)
	     .orElse(0);
	    assertEquals(8, len);
	}
	//将filter()与map()一起使用可以做一些很强力的事情。
	@Test
	public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
	    String password = " password ";
	    Optional<String> passOpt = Optional.of(password);
	    boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
	    assertFalse(correctPassword);
	 
	    correctPassword = passOpt
	      .map(String::trim)//如果不进行trim，则会返回false，这里我们可以使用map()进行trim。
	      .filter(pass -> pass.equals("password"))
	      .isPresent();
	    assertTrue(correctPassword);
	}
	//flatmap()有时我们可以使用flatmap()替换map()，二者不同之处在于，
	//map()只有当值不被包裹时才进行转换，而flatmap()接受一个被包裹着的值并且在转换之前对其解包。
	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect2() {
	    Employee person = new Employee("john", 26);
	    Optional<Employee> personOptional = Optional.of(person);
	    //需要注意，方法getPassword返回的是一个Optional对象，而不是像trim那样。这样就生成了一个嵌套的Optional对象。
	    //因此使用map，我们还需要再解包一次，而使用flatMap()就不需要了。
	    Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Employee::getPassword);
	    //解包
	    Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
	    String name1 = nameOptional.orElse("");
	    assertEquals("john", name1);
	    
	    String name = personOptional
	      .flatMap(Employee::getPassword)
	      .orElse("");
	    assertEquals("john", name);
	}
}
