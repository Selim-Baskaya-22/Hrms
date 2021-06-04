package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Job;


/*Jpa calisma mantigi;
 * Arkadaslar buradaki mantik sana bir tane job tipinde entity göndericem sende onu benim icin belli islemlere tabi tutucaksın
  (add,delete,findAll) gibi bir komut vermis oluyoruz. 
 * Peki bizim bu JpaRepository Job nesnemizi nereden tanıyor?
    Arkdaslar burada ise hatirlarsaniz biz entitylerimizin üzerine @Entity annotationsı eklemistik. Bu JpaRepository aslinda 
    tam olarak oraya bakıyor.JpaRepository icerisindeki methodlari incelerseniz Job alanındaki generic yapı olan T entitysinin    
    aslında bir @Entity annotationsı olması gerekiyor diye kurallar koyulmus. Eger siz Job taki @Entity silerseniz calisma aninda 
    hata aliriz. 

  *Integer neyin nesi?
    Orada ise benim primary keyimim veri tipini belirtmis oluyoruz. Bunu nerden tanıyor diye sorarsanız onuda Job'un içersindeki
    @Id annotationundan taniyor. Kurallar ayni @Entity deki gibi isliyor.
  
  *Peki neden böyle bir yapi kullaniliyor?
    Bunun aslinda bircok nedeni var. Ben bildiklerimi ve akilda kalici olanlari anlatayim
    1)Oncelikle tüm crud operasyonlarinda iclerine biz herhangi bir hibernate kodu yazmadigimizda büyük bir yukten kurtuluyoruz
    2)Yazilim ortamlari(sonucta bir insan oldugumuzdan) hata yapmaya cok müsaittir. Iste bunlarin buyuk bir kismini ortadan
     kaldirmis oluyoruz. Eger bu yapiyi kullanmasaydik Job yerine herhangi bir sinif yazabilecek ve hatasini bulmakta zorlanacakti.
     İste bu yapida @Entity kuralini gecemedigi icin calistirma aninda hata vericek ve programci hatasini kolayca farkedebilecektir 
  */
public interface JobDao extends JpaRepository<Job, Integer>{
  Job getByName(String name);
}
