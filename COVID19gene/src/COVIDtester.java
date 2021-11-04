

import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.io.*; 


/**
 * this program can find codons a user searches for within COVID-19
 * @author jefftabaka
 * created oct 23, 2020
 * COSC-1437.005
 *
 */
public class COVIDtester {
	
	public static void main(String[]args)throws IOException
	{
		
		
	
		
		String triple = null;
		int searchNum = 0;
		int codonTotal = 0;
		int codonCount = 0;
		double searchTotal = 0.0;
		double searchPercentage = 0.0;
		double percentOfTotal = 0;
		
		
		// read in file and put data into array
		// create file
		File myfile = new File("covid19sequence.txt");
		//create scanner
		Scanner infile = new Scanner(myfile); 
		// create arrayList
		List<String> codonList = new ArrayList<>();
		
		// loop to read in file
		while (infile.hasNextLine())
		{
			
			// read in each line and save to String, "line"
			String line = infile.nextLine();
			
//	check		//System.out.println(line);
		
			// loop to add to arrayList as triples 
			for(int i = 0; i < (line.length()); i+=3)
			{
// check		System.out.print(line.substring(i, i+3) + " "); 
				codonList.add(line.substring(i, i+3));	
				// keep a total codon count
				codonCount += 1;
				
			}
			
		}
		// create a new scanner
		Scanner kbd = new Scanner(System.in);
		// loop to get user info
		do
		{
			System.out.print("Press '0' to exit, or:\nHow many codons (1-10) do you want to search for?");
			searchNum = kbd.nextInt();
		} while (searchNum < 0 || searchNum >= 10);
		
		// create arrays to hold values
				int[] resultsArray = new int[searchNum];
				double[] resultsArrayD = new double[searchNum];
				ArrayList<String> searchArrayList = new ArrayList<String>();
	
		// loop to search for each codon
		for(int index = 0; index < searchNum; index++)
		{
			codonTotal = 0;
			System.out.print("what is codon #"+(index + 1)+ " you are searching for? ");
			triple = kbd.next();
			searchArrayList.add(triple.toUpperCase());
			triple.toLowerCase();
// check	System.out.println(triple);
			// loop to count
			for(int count  = 0; count < codonList.size(); count++)
			{
				if(codonList.get(count).contains(triple))
				{
					codonTotal += 1;
				}
			}
			// save results
			resultsArray[index] = codonTotal;
			resultsArrayD[index] = codonTotal;
			searchTotal += codonTotal;
		}
		
// print results
		System.out.println();
		System.out.println(aminoAcidName(searchArrayList) + " Codon Counts:");

		for(int i = 0; i < searchNum; i++)
		{
			searchPercentage = (resultsArray[i] / searchTotal) *100;
			System.out.printf("%s: %d \t%.2f percent \n", searchArrayList.get(i), resultsArray[i], searchPercentage );
		}
//		System.out.println(searchTotal);
//		System.out.println(codonCount);
		
		percentOfTotal = (searchTotal / codonCount) * 100;
		System.out.printf("%s accounts for %.2f of the total genome.", aminoAcidName(searchArrayList), percentOfTotal);
		
		
// close the file
		infile.close();
		
		
		
	
	}
	/**
	 * method to find the name of amino acid user is searching for
	 * @param tripleArrayList
	 * @return name of amino acid if any
	 */
	public static String aminoAcidName (ArrayList<String> tripleArrayList)
	{
		String aminoAcid = null;	
		
			if(tripleArrayList.contains("TTA")
					&& tripleArrayList.contains("TTG")
					&& tripleArrayList.contains("CTT") 
					&& tripleArrayList.contains("CTC")
					&& tripleArrayList.contains("CTA")
					&& tripleArrayList.contains("CTG"))
			{
				aminoAcid = "(Leu/L) Leucine";
			} else
			if(tripleArrayList.contains("CGT")
					&& tripleArrayList.contains("CGC")
					&& tripleArrayList.contains("CGA") 
					&& tripleArrayList.contains("CGG"))
			{
				aminoAcid = "(Arg/R) Arginine";
			}else
			if(tripleArrayList.contains("GTT")
					&& tripleArrayList.contains("GTC")
					&& tripleArrayList.contains("GTA") 
					&& tripleArrayList.contains("GTG"))
			{
				aminoAcid = "(Val/V) Valine";
			}else
			if(tripleArrayList.contains("TCT")
					&& tripleArrayList.contains("TCC")
					&& tripleArrayList.contains("TCA") 
					&& tripleArrayList.contains("TCG"))
			{
				aminoAcid = "(Ser/S) Serine";
			}else
			if(tripleArrayList.contains("CCT")
					&& tripleArrayList.contains("CCC")
					&& tripleArrayList.contains("CCA") 
					&& tripleArrayList.contains("CCG"))
			{
				aminoAcid = "(Pro/P) Proline";
			}else
			if(tripleArrayList.contains("ACT")
					&& tripleArrayList.contains("ACC")
					&& tripleArrayList.contains("ACA") 
					&& tripleArrayList.contains("ACG"))
			{
				aminoAcid = "(Thr/T) Threonine";
			}else
			if(tripleArrayList.contains("GCT")
					&& tripleArrayList.contains("GCC")
					&& tripleArrayList.contains("GCA") 
					&& tripleArrayList.contains("GCG"))
			{
				aminoAcid = "(Ala/A) Alanine";
			}else
			if(tripleArrayList.contains("GGT")
					&& tripleArrayList.contains("GGC")
					&& tripleArrayList.contains("GGA") 
					&& tripleArrayList.contains("GGG"))
			{
				aminoAcid = "(Gly/G) Glycine";
			}else
			if(tripleArrayList.contains("ATT")
					&& tripleArrayList.contains("ATC")
					&& tripleArrayList.contains("ATA"))
			{
				aminoAcid = "(Ile/I) Isoleucine";
			}else
			if(tripleArrayList.contains("TAT")
					&& tripleArrayList.contains("TAC"))
			{
				aminoAcid = "(Tyr/Y) Tyrosine";
			}else
			if(tripleArrayList.contains("TTT") 
					&& tripleArrayList.contains("TTC"))
			{
				aminoAcid = "(Phe/F) Phenylalanine";
			}else
			if(tripleArrayList.contains("CAT")
					&& tripleArrayList.contains("CAC"))
			{
				aminoAcid = "(His/H) Histidine";
			}else
			if(tripleArrayList.contains("CAA")
					&& tripleArrayList.contains("CAG"))
			{
				aminoAcid = "(Gln/Q) Glutamine";
			}else
			if(tripleArrayList.contains("AAT")
					&& tripleArrayList.contains("AAC"))
			{
				aminoAcid = "(Asn/N) Asparagine";
			}else
			if(tripleArrayList.contains("AAA")
					&& tripleArrayList.contains("AAG"))
			{
				aminoAcid = "(Lys/K) Lysine";
			}else
			if(tripleArrayList.contains("GAT")
					&& tripleArrayList.contains("GAC"))
			{
				aminoAcid = "(Asp/D) Aspartic acid";
			}else
			if(tripleArrayList.contains("GAA")
					&& tripleArrayList.contains("GAG"))
			{
				aminoAcid = "(Glu/E) Glutamic acid";
			}else
			if(tripleArrayList.contains("TGT")
					&& tripleArrayList.contains("TGC"))
			{
				aminoAcid = "(Cys/C) Cysteine";
			}else
			if(tripleArrayList.contains("AGT")
					&& tripleArrayList.contains("AGC"))
			{
				aminoAcid = "(Ser/S) Serine";
			}else
			if(tripleArrayList.contains("AGA")
					&& tripleArrayList.contains("AGG"))
			{
				aminoAcid = "(Arg/R) Arginine";
			}else
			if(tripleArrayList.contains("TAA"))
			{
				aminoAcid = "(STOP) Ochre";
			}else
			if(tripleArrayList.contains("TAG"))
			{
				aminoAcid = "(STOP) Amber";
			}else
			if(tripleArrayList.contains("TGA"))
			{
				aminoAcid = "(STOP) Opal";
			}else
			if(tripleArrayList.contains("TGG"))
			{
				aminoAcid = "(Trp/W) Tryptophan";
			}else
			if(tripleArrayList.contains("ATG"))
			{
				aminoAcid = "(Met/M) Methionine";
			}else
			{
				aminoAcid = "Your selected";
			}
			return aminoAcid;
	}
	
			

}

