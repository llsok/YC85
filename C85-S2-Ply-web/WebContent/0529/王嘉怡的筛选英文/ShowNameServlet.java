package day0521;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowNameServlet.do")
public class ShowNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] names = {"Abe","Abraham","Acheson","Ackerman(n)","Adam","Adams","Addison","Adela","Adelaide","Adolph","Agnes","Albert","Alcott","Aldington","Aldridge","Aled(k)","Alerander","Alfred","Alice","Alick","Alsop(p)","Aly","Amelia","Anderson","Andrew","Ann","Anna","Anne","Anthony","Antoinette","Antonia","Arabella","Archibald","Armstrong","Arnold","Arthur","Attlee","Augustine","Augustus","Austen","Austin","Babbitt","Bach","Bacon","Baldwin","Barnard","Barney","Barrett","Barrie","Bart","Bartholomew","Bartlett","Barton","Bauer","Beard","Beaufort","Becher","Beck","Becky","Beerbohm","Bell","Bellamy","Belle","Belloc","Ben","Benedict","Benjamin","Bennett","Benson","Bentham","Berkeley","Bernal","Bernard","Bert","Bertha","Bertie","Bertram","Bess","Bessemer","Bessie","Bethune","Betsy","Betty","Bill","Billy","Birrell","Black","Blake","Bloomer","Bloomfield","Bloor","Blume","Bob","Bobby","Boswell","Bowen","Bowman","Boyle","Bradley","Bray","Brewster","Bridges","Bright","Broad","Bronte","Brooke","Brown","Browne","Browning","Bruce","Bruno","Bryan","Bryce","Buck","Buckle","Bulwer","Bunyan","Burke","Burne-Jones","Burns","Butler","Byron","Camilla","Camp","Carey","Carl","Carllyle","Carmen","Carnegie","Caroline","Carpenter","Carrie","Carroll","Carter","Catharine","Cecillia","Chamberlain","Chaplin","Chapman","Charles","Charley","Charlotte","Charles","Chaucer","Chesterton","Child","Childe","Christ","Christian","Christiana","Christie","Christopher","Christy","Church","Churchill","Cissie","Clapham","Clara","Clare","Clarissa","Clark(e)","Clemens","Clement","Cocker","Coffey","Colclough","Coleridge","Collins","Commons","Conan","Congreve","Connie","Connor","Conrad","Constance","Cook(e)","Cooper","Copperfield","Cotton","Coverdale","Cowper","Craigie","Crane","Crichton","Croft","Crofts","Cromwell","Cronin","Cumberland","Curme","Daisy","Dalton","Dan","Daniel","Daniell","Darwin","David","Davy","Defoe","Delia","Den(n)is","DeQuincey","Dewar","Dewey","Dick","Dickens","Dickey","Dillon","Dobbin","Dodd","Doherty","Dolly","Donne","Dora","Doris","Dorothea","Dorothy","Douglas(s)","Doyle","Dierser","Dryden","DuBois","Dulles","Dunbar","Duncan","Dunlop","Dupont","Dutt","Eddie","Eden","Edgeworth","Edie","Edison","Edith","Edmund","Edward","Effie","Eipstein","Eisenhower","Eleanor","Electra","Elinor","Eliot","Elizabeth","Ella","Ellen","Ellis","Elsie","Emerson","Emily","Emma","Emmie","Ernest","Esther","Eugen","Eugene","Euphemia","Eva","Evan","Evans","Eve","Evelina","Eveline","Ezekiel","Fanny","Faraday","Fast","Faulkner","Felix","Felton","Ferdinand","Ferguson","Field","Fielding","Finn","FitzGerald","Flower","Flynn","Ford","Forster","Foster","Fowler","Fox","Frances","Francis","Frank","Franklin","Fred","Frederick","Freeman","Funk","Gabriel","Galbraith","Gallacher","Gallup","Galsworthy","Garcia","Garden","Gard(i)ner","Gaskell","Geoffrey","Geordie","George","Gibbon","Gibson","Gilbert","Giles","Gill","Gissing","Gladstone","Godwin","Gold","Goldsmith","Gosse","Grace","Gracie","Graham","Grant","Grantham","Gray","Green","Gregory","Gresham","Grey","Grote","Gunter","Gunther","Gus","Guy","Habakkuk","Haggai","Hal","Halifax","Hamilton","Hamlet","Hansen","Hansom","Hardy","Harold","Harper","Harriman","Harrington","Harrison","Harrod","Harry","Hart","Harte","Harvey","Hawthorne","Haydn","Haywood","Hazlitt","Hearst","Helin(a)","Hemingway","Henley","Henrietta","Henry","Herbert","Herty","Hewlett","Hicks","Hill","Hobbes","Hobson","Hodge","Hodgson","Holmes","Holt","Hood","Hoover","Hope","Hopkin(s)","Horace","Horatio","Hornby","Hosea","House","Housman","Houston","Howard","Howell(s)","Hoyle","Hubbard","Hudson","Huggins","Hugh","Hughes","Hume","Humphr(e)y","Huntington","Hutt","Huxley","Ingersoll","Irving","Isaac","Isabel","Isaiah","Ivan","Jack","Jackson","Jacob","James","Jane","Jasper","Jeames","Jean","Jefferson","Jenkin(s)","Jennings","Jenny","Jeremiah","Jeremy","Jerome","Jerry","Jessie","Jim","Jimmy","Joan","Job","Joe","Joel","John","Johnny","Johnson","Johnston(e)","Jonah","Jonathan","Jones","Jonson","Jordan","Joseph","Josh","Joshua","Joule","Joyce","Judd","Judith","Judson","Julia","Julian","Juliana","Juliet","Julius","Katte","Katharine","Kathleen","Katrine","Keats","Kell(e)y","Kellogg","Kelsen","Kelvin","Kennan","Kennedy","Keppel","Keynes","Kingsley","Kipling","Kit","Kitto","Kitty","Lamb","Lambert","Lancelot","Landon","Larkin","Lattimore","Laurie","Law","Lawrence","Lawson","Leacock","Lee","Leigh","Leighton","Lena","Leonard","Leopold","Lew","Lewis","Lily","Lincoln","Lindberg(h)","Lindsay","Lizzie","Lloyd","Locke","London","Longfellow","Longman","Lou(ie)","Louis","Louisa","Louise","Lowell","Lucas","Lucia","Lucius","Lucy","Luke","Lyly","Lynch","Lynd","Lytton","MacAdam"};
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String str=request.getParameter("str");
		String result="";
		for(int i=0;i<names.length;i++) {
			if(names[i].toString().startsWith(str)==true) {
				result +=names[i].toString()+",";
			}
		}
		response.getWriter().append(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
