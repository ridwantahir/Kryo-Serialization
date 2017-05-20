package intelligdata.domain;

public class Course {
		String title;
		int crHr;
		public Course(){
			
		}
public Course(String title, int crHr){
			this.title=title;
			this.crHr=crHr;
		}
		@Override
		public String toString(){
			return title+": "+crHr+" CRH";
		}
		
}
