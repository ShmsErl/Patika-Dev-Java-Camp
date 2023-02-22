package com.listofcreate;

/**
 * Bu sınıfın amacı dinamik bir Dizi tutması ve veri tipini dinamik olarak
 * almasıdır. Dolayısıyla bu sınıf generic bir dizi sınıfıdır.
 *
 * Sınıf Özellikleri;
 *
 * 1 - Sınıf içerisindeki dizinin varsayılan boyutu 10 ve dizinin eleman sayısı
 * ihtiyaç duydukça 2 katı şeklinde artmaktadır. [OK] 2 - Sınıfa ait iki tür
 * constructor bulunmalıdır. [OK] 3 - MyList boş constructor kullanılırsa
 * dizinin başlangıç boyutu 10 olmalıdır. [OK] 4 - MyList(int capacity) dizinin
 * başlangıç değeri capacity parametresinden alınmalıdır. [OK] 5 - size()
 * dizideki eleman sayısını verir. [OK] 6 - getCapacity() dizinin kapasite
 * değerini verir. [OK] 7 - add(T data) sınıfa ait diziye eleman eklemek için
 * kullanılmalıdır. Eğer dizide yeteri kadar yer yoksa dizi boyutu iki katına
 * çıkarılmalıdır. [OK]
 *
 * 8 - get(int index) verilen indisteki değeri döndürür. Geçersiz indis
 * girilirse null döndürür. [OK] 9 - remove(int index) verilen indisteki değeri
 * silip, değerleri sola doğru kaydırır. Geçersiz indis girilirse null döndürür.
 * [OK] 10 - set(int index, T data) verilen indisteki değeri gönderilen veri ile
 * değiştirir. Geçersiz indis girilirse null döndürür. [OK] 11 - String
 * toString() Sınıfa ait dizideki elemanları listeleyen metod. [OK]
 *
 * 12 - int indexOf(T data) : Parametrede verilen nesnenin listedeki indexini
 * verir. Nesne listede yoksa -1 değerini verir. [OK] 13 - int lastIndexOf(T
 * data) : Parametrede verilen nesnenin listedeki son indexini verir. Nesne
 * listede yoksa -1 değerini verir. [OK] 14 - boolean isEmpty() : Listenin boş
 * olup olmadığını true ya da false değeri döndürerek bildirir. [OK] 15 - T[]
 * toArray(): Listedeki öğeleri aynı sırayla bir dizi haline getirip geriye
 * döndürür. Yalnızca elemanları içeren bir dizi. [OK] 16 - clear() : Listedeki
 * bütün öğeleri siler, boş bir liste haline getirir. [OK] 17 - MyList<T>
 * sublist(int start, int finish) : Parametrede verilen index aralığına ait bir
 * liste döner. [OK] 18 - boolean contains(T data) : Parametrede verilen değerin
 * listede olup olmadığını söyler. [OK]
 */

public class List<T> implements MyList<T>{
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private int initialCapacity;
	private int size = 0;
	private transient Object[] array;

	/**
	 * Varsayılan Parametresiz Constructor.
	 *
	 */
	@SuppressWarnings("unchecked")
	public List() {
		this.array = (T[]) new Object[DEFAULT_CAPACITY];
		setInitialCapacity(DEFAULT_CAPACITY);

	}

	/**
	 * Parametreli Constructor Metodu.
	 *
	 * @param capacity oluşturulmak istenen dizinin boyutunu temsil eder. Burada
	 *                 değer girerek istenilen boyutta (eleman sayısına sahip) dizi
	 *                 oluşturulabilir.
	 *
	 *
	 */

	public List(int initialCapacity) {
		if (initialCapacity > 0) {
			setInitialCapacity(initialCapacity);
			this.array = (T[]) new Object[this.initialCapacity];
		} else if (initialCapacity == 0) {
			this.array = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	/**
	 * <pre>
	 * Bu metot dizinin kapasitesini geriye döndürür.
	 * Dizinin kapasitesi ile eleman sayısı aynı şey değildir.
	 * Dizinin kapasitesi 10 fakat eleman sayısı 0,1,2...10 olabilir.
	 * </pre>
	 * 
	 * @return Kapasite
	 */
	public int getInitialCapacity() {
		return initialCapacity;
	}

	public void setInitialCapacity(int initialCapacity) {
		this.initialCapacity = initialCapacity;
	}

	/**
	 * Dizide bulunan boş yer sayısını geriye döndürür. Örneğin dizi kapasitesi 10
	 * ve içerisinde 7 eleman varsa, geriye 3 döndürecektir.
	 * 
	 * @return (Integer) boş yer sayısı.
	 */
	public int getAvailableCapacity() {
		return getInitialCapacity() - getSize();
	}

	/**
	 * <pre>
	 * Dizinin eleman sayısını bulan metottur.
	 * Burada dikkat edilmesi gereken geriye kapasiteyi değil, mevcutta bulunan eleman sayısını,
	 * yani null olmayan değer sayısını döndürecektir.
	 * </pre>
	 * 
	 * @return (Integer)eleman sayısı.
	 */

	public int getSize() {
		int size = 0;

		for (Object object : this.array) {

			if (object != null) {
				size++;

			}

		}
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Generic Array'imize erişmek için kullanılmalıdır. Geriye mevcuttaki Array'i
	 * T[] tipinde döndürecektir.
	 *
	 *
	 * @return
	 */
	public Object[] getArray() {
		return array;
	}

	/**
	 * Gönderilen Object Türündeki diziyi T generic türüne cast ederek, mevcuttaki
	 * generic diziye atar.
	 *
	 * Örneğin Object türünde 30 elemanlı yeni bir dizi oluşturup yollarsanız new
	 * Object[30] şeklinde parametre geçebilirsiniz.
	 *
	 * Dışarıdan erişimi kapalıdır. Yalnızca doubleCapacity metodu tarafından
	 * kontrollü bir şekilde kullanılmalıdır. Aksi taktirde veri kaybına yol
	 * açacaktır.
	 *
	 * @param array
	 */
	public void setArray(Object[] array) {
		this.array = array;
	}

	/**
	 * <pre>
	 * Diziye tek bir eleman eklemek için kullanılan, tek parametreli metod.
	 * Eklenilecek olan eleman, sınıf tanımlanırken kullanılan, belirtilen türde olmalıdır.
	 * Metod eleman eklemesi yapmadan önce yeterli yer olup olmadığını kontrol eden checkCapacity metodunu çağırır.
	 * </pre>
	 * 
	 * @param element
	 */

	public void add(T data) {

		if (size >= this.initialCapacity) {

			grow();

		} else {
			this.array[size] = data;
			size++;
		}

	}

	/**
	 * <blockquote> Dizinin kapasitesini iki katına çıkartır. </blockquote> Örneğin
	 * dizi kapasitesi 10 ise sırasıyla aşağıdaki işlemleri yapacaktır. <blockquote>
	 * 
	 * <pre>
	 *     1 - Diziyi olduğu gibi geçici bir başka diziye atayarak elemanların yedeğini alır.
	 *     2 - Diziyi yeniden tanımlar. Bu sırada eleman sayısını mevcut olanın 2 katı olarak ayarlar. (10 ise 20, 20 ise 40 gibi)
	 *     3 - Ardından yeni oluşturulan ve boş olan diziye eski elemanları eski sırayla atamaya başlar.
	 * </pre>
	 * 
	 * </blockquote>
	 */

	public void grow() {
		T[] tempArray = (T[]) getArray();
		setArray(new Object[getInitialCapacity() * 2]);
		setInitialCapacity(getInitialCapacity() * 2);
		for (int i = 0; i < tempArray.length; i++) {

			this.array[i] = tempArray[i];
		}

	}

	/**
	 * Parametre olarak gönderilen indexte bulunan elemanı geriye döndürür. Eğer
	 * geçersiz bir index gönderilirse null döndürür.
	 *
	 * @param index elemanın indis numarasını temsil eder.
	 * @return T tipinde dizi elemanını geriye döndürür.
	 */

	public void getIndex(int index) {
		try {
			System.out.println(this.array[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Geçersiz index numarası " + index + "\n");
		}

	}

	/**
	 * Belirtilen index numarasındaki veriyi, gönderilen veri ile değiştiren metod.
	 *
	 * @param index değiştirilmek istenen verinin konumunu, indis numarasını
	 *              belirtir.
	 * @param data  yeni veriyi belirtir.
	 * @return işlem başarılı ise true, başarısız ise false döndürür.
	 */

	public boolean setValue(int index, T value) {

		if (index < 0 || index > getInitialCapacity()) {
			System.out.println("Girdiğiniz İndex Numarası Geçerli Aralıkta Değildir!!! " + index);
			return false;

			// Eğer index numarası, mevcut dizinin sınırları içerisindeyse çalışacak kod
			// bloğu,
			// Aksi taktirde out of bounds hatası alırız, bunu önlemek için bu kontrolleri
			// yapıyoruz.
		} else {
			array[index] = value;
			System.out.println("Değiştirme İşlemi Başarı İle Gerçekleşti " + array[index]);
			return true;
		}

	}

	/**
	 * <pre>
	 * Diziyi ekrana yazdırmak için kullanılır.
	 * Bütün elemanları tek tek, satır satır konsola yazdırır.
	 * Geriye değer döndürmez.
	*
	 * Null durumda olan bir class'ı toString ile yazıdrmaya kalktığında hata alırsın.
	 * Burada bunu her ne kadar önlemeyi denesem de olmadı, dönüp bakacağım buraya. ! ! ! ! ! ! ! ! !
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		String elementData = "[";
		for (Object object : this.array) {

			elementData += (T) object + " ,";

		}
		elementData += "]";

		return elementData;

	}

	/**
	 * Parametre ile gönderilen indis değerini diziden siler, diziyi sola kayıdırır.
	 * İşlem başarılı olursa geriye true, başarısız olursa geriye false değerini ve
	 * akabinde konsola hatayı belirten mesajı döndürür.
	 *
	 * @param index silinmek istenen elemanın indis numarasını temsil eder.
	 * @return true ya da false olarak işlem sonucunu döndürür.
	 */

	public void remove(T value) {

		for (int i = 0; i < (array.length); i++) {

			if (array[i] == value) {

				for (int j = i; j < (array.length - 1); j++) {

					array[j] = array[j + 1];

					i++;

				}
				array[getInitialCapacity() - 1] = null;

			}

		}

	}

	/**
	 * <pre>
	 * Gönderilen verinin dizide olup olmadığın kontrol eder. İlk indexini geriye döndürür.
	 * Eğer veri dizide mevcutsa hangi indexte olduğu bilgisi döner.
	 * Eğer veri dizide mevcut değilse geriye -1 değeri döner.
	 *
	 * Bu metodda dikkat edilmesi gereken metod yapısı gereği ilgili elemanın ilk indexini verecektir.
	 * Örneğin "Muhammet" değerini string türde bir dizide arıyor olalım. Bu elemandan birden fazla olabilir.
	 * İlki 5. indexte ikincisi 15. indexte olabilir. Aşağıdaki kod 5. indexte onu tespit ettiği an return ile geriye indexini döndürecek
	 * Ardından return yaptığı için metod sonlanacaktır.
	 * </pre>
	 * 
	 * @param data dizi içerisinde aranacak olan veri, eleman.
	 * @return ilgili veri dizide varsa onun index numarası, yoksa -1 döner.
	 */
	public int indexOf(T data) {

		for (int i = 0; i < this.array.length; i++) {

			if (this.array[i] == data) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * <pre>
	 * Bu metod parametre olarak gönderilen veriyi dizi içerisinde arar ve hangi indexte olduğunu bulur.
	 * Bu metodun indexOf metodundan farkı indexOf metodu bulunduğu ilk indexi verirken,
	 * lastIndexOf metodu bulunduğu en son indexi verir.
	 * </pre>
	 * 
	 * @param data dizi içerisinde aranacak olan veriyi temsil eder.
	 * @return geriye eğer dizi içerisinde ilgili eleman varsa, bulunduğu en son
	 *         indexi, yoksa -1 döndürür.
	 */
	public int lastİndexOf(T data) {

		for (int i = this.array.length - 1; i > 0; i--) {

			if (this.array[i] == data) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * <pre>
	 * Dizinin boş olup olmadığını (Yani içerisinde veri olup olmadığını) kontrol eden metod.
	 * Eğer dizide 1 veya daha fazla eleman varsa geriye false döner,
	 * Eğer dizide eleman yoksa geriye true döner.
	 * </pre>
	 * 
	 * @return eğer boş ise true, dolu ise false döner.
	 */
	public boolean isEmpty() {

		for (Object object : this.array) {

			if (object != null) {

				return false;
			}

		}

		return true;
	}

	/**
	 * Liste içerisindeki elemanları (null veriler hariç) Yeni bir dizi olarak
	 * geriye döndürür.
	 * 
	 * @return T[] türünde sadece listenin dolu elemanlarını içeren dizi.
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {

		T[] ts = (T[]) new Object[this.array.length];
		for (int i = 0; i < this.array.length; i++) {
			ts[i] = (T) this.array[i];

		}

		return ts;
	}

	/**
	 * Listedeki bütün öğeleri siler, bunu diziyi baştan oluşturarak yapar.
	 */
	public void clear() {

		for (int i = 0; i < this.array.length; i++) {

			this.array[i] = null;

		}
		System.out.println("Liste Temizlendi mi ?  " + isEmpty());
	}

	/**
	 * Başlangıç ve bitiş noktası parametre aracılığıyla belirtilen nesneden yeni
	 * bir liste nesnesi oluşturur. Eğer negatif bir değer girersen ya da mevcut
	 * listenin aralığı dışında bir değer girersen geriye null olarak bu nesneden
	 * döndürür. Bu nesneyi aman diyeyim yazdırma exception atmadan yaptım hataya
	 * düşeriz toString ile
	 *
	 * @param start  başlangıç indexini belirtir.
	 * @param finish bitiş indexini belirtir.
	 * @return başlangıç ve bitiş indexleri de dahil olmak üzere arada kalana
	 *         elemanlardan yeni bir liste oluşturur.
	 */
	public List<T> sublist(int start, int finish) {

		List<T> newList = new List<>(finish);

		for (int i = start; i < finish; i++) {
			T deger = (T) this.array[i];

			newList.add(deger);
			start++;

		}

		return newList;

	}

	/**
	 * Parametre olarak gönderilen verinin listede olup olmadığını kontrol eder.
	 *
	 * @param data liste içerisinde aranacak veri.
	 * @return data listede varsa geriye true, listede yoksa false döner.
	 */
	public boolean includes(T data) {

		for (Object object : this.array) {

			if (object == (data)) {

				return true;
			}

		}
		return false;
	}

}
