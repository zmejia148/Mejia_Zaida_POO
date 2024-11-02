El objetivo del siguiente sistema es crear un pequeño pryecto que gestione los diferentes tipos de contenidos como audiovisual, películas, series de televisión, documentales, cortometrajes y videos de YouTube. esta permite asociar actores, investigadores y temporadas con los diferentes tipos de contenidos.

Clases y funciones
Clase Actor :
Representar
Métodos:
agregarPelicula(Pelicula pelicula):Permite añadir una
mostrarDetalles():Muestreo

Clase Temporada :
Representa
Método:
mostrarInformacion(): Muestra

Clase Investigador :
Representar
Métodos:
agregarDocumental(Documental documental):Permanente
mostrarDetalles():Muestra

Funcionalidades de Asociación :
La clase SerieDeTVa
La clase Actorpuede actuar
La clase Investigadorpuede estar

INSTRUCCIONES PARA CLONAR EL PROYECTO 

Bueno esto depende de como se maneje pro una buena opcion es seleccionar el boton de file y la opcion de imortar 
![image](https://github.com/user-attachments/assets/5228e6fb-7a7a-4b82-bbb1-3904109e3a3f)

Una ves que se haya seleccionado esa opcion se abrira una vista emergente en la cual se debe seleccionar la opcion de Projects from Git y next
![image](https://github.com/user-attachments/assets/fed81360-672c-419f-9c5e-9a2242677ed1)

de hay seleccionamos la opcion de Clone URL
![image](https://github.com/user-attachments/assets/e90351f1-36bc-43a7-98f5-0f46f3307a94)

En la vista emergente colocamos el link del proyecto https://github.com/zmejia148/Mejia_Zaida_POO y coloca su usuario y password
![image](https://github.com/user-attachments/assets/5f6a8924-9c30-4dbd-8120-29e92700b784)

selecciona next y asi hasta que llegue a la vista donde va a validar la ubicación en donde se guardara el proyecto 
![image](https://github.com/user-attachments/assets/647f04d1-e722-4cb6-8cb4-2d38040696e5)

Deja la opcion por defecto y selecciona next 
![image](https://github.com/user-attachments/assets/4b6aa6ed-fd4e-4d3e-9bf5-479cb8e2857f)

En la ultima vista coloca el nombre on el que desea que se guarde y selecciona finish 
![image](https://github.com/user-attachments/assets/2e5e9e45-2d23-4267-a7d1-e779b9f566fc)


OPTIMIZACIÓN DEL CODIGO

Organice el codigo para que cada clase tenga sus propias responsabilidades para seguir el metodo de responsabilidad unica, con esto cada clase tiene sus propios metodos, cree un método mostrarDetalles()en cada clase, permitiendo que cada tipo de contenido (película, serie, documental, etc.) pueda mostrar su información de manera autónoma y se pueda personalizar dependiendo el caso o los gustos.
Tambien utilice listas para realizar las asociaciones como en el caso de Actor, se utilizó una lista ( List<Pelicula> peliculas) para asociar peliculas con actor.
Mejore la vista de salida ya que le coloque espacion y coloque identificadores para cada titulo para diferenciar cuando cambia de tema. 





