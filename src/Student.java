import java.math.BigDecimal;

public class Student {

	private String name;
	private Integer age;
	private BigDecimal propValue;

	public Student() {

	}

	public Student(String name, Integer age, BigDecimal propValue) {
		super();
		this.name = name;
		this.age = age;
		this.propValue = propValue;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getPropValue() {
		return propValue;
	}

	public void setPropValue(BigDecimal propValue) {
		this.propValue = propValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", propValue=" + propValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((propValue == null) ? 0 : propValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (propValue == null) {
			if (other.propValue != null)
				return false;
		} else if (!propValue.equals(other.propValue))
			return false;
		return true;
	}

}
