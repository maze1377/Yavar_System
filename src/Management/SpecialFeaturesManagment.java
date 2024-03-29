package Management;

import Model.Date;
import Model.Document;
import Model.SpecialDocument;
import Model.User;

public class SpecialFeaturesManagment {

    public SpecialDocument createNewSpecialFeatures(Date startDate, Document document, int mounth) {
        int cost = getcost(mounth);
        return new SpecialDocument(startDate,document,cost,mounth);
    }

    public boolean addSpecialFeature(SpecialDocument specialDocument , User user){
            if(showRoles()){
                if( user.getCredit()-specialDocument.getCost()>0){
                    user.setCredit((long)user.getCredit()-specialDocument.getCost());
                    user.addSpecialFeature(specialDocument);
                    return true;
                }else{
                    showerror("not enough cost");
                   if( AccountManagement.withdraw(user,specialDocument.getCost()-user.getCredit())){
                       user.setCredit((long)user.getCredit()-specialDocument.getCost());
                       user.addSpecialFeature(specialDocument);
                       return true;
                   }else{
                       showerror("not enough cost");
                       return false;

                   }


                }
            }else{
                showerror("dont accept roles");
                return false;
            }

    }


    public boolean removeSpecialFeature(User user ,SpecialDocument specialDocument){
        for(int w = 0 ;w <user.getSpecialFeatures().size();w++){
            if(specialDocument.getDocument().equals(user.getSpecialFeatures().get(w).getDocument())){
                SpecialDocument removed = user.getSpecialFeatures().get(w);
                int returncost = returncost(removed.getStartDate(),removed.getMounth(),removed.getCost());
             if (  showreturnedcost(returncost)){
                 user.setCredit((long)user.getCredit()+returncost);
                 user.removeSpecialFeature(user.getSpecialFeatures().get(w));
                 return true;
             }else{
                 showerror("special dont do");
                 return false;
             }
            }
        }
        return false;

    }
    private boolean showreturnedcost(int cost){
        return true;
    }

    private int returncost(Date startdate , int mounth , int cost){
        return 1000;
    }
    private int getcost(int mounth){
        return 1000*mounth;
    }

    private boolean showRoles(){
        return true;
    }

    private void showerror(String message){

    }

}
