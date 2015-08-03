package jp.ac.kansai_u.kutc.firefly.aiwolf;



/**
 * This class manage detail of agentpoint.
 *
 * @author Yuki Nojima
 */
public class AgentPoint {
    private int sip_wolf[] = new int[15];
    private int sip_villager[] = new int[15];
    private int sip_bodygurad[] = new int[15];
    private int sip_seer[] = new int[15];
    private int sip_possessed[] = new int[15];
    private int sip_medium[] = new int[15];
    private int scp[] = new int[15];
    
    private int oip_wolf[] = new int[15];
    private int oip_villager[] = new int[15];
    private int oip_bodygurad[] = new int[15];
    private int oip_seer[] = new int[15];
    private int oip_possessed[] = new int[15];
    private int oip_medium[] = new int[15];
    private int ocp[] = new int[15];
    
    public AgentPoint(){
        for(int i=0;i<15;i++){
            sip_wolf[i]=50;
            sip_villager[i]=50;
            sip_bodygurad[i]=50;
            sip_seer[i]=50;
            sip_possessed[i]=50;
            sip_medium[i]=50;
            scp[i]=50;
            
            oip_wolf[i]=50;
            oip_villager[i]=50;
            oip_bodygurad[i]=50;
            oip_seer[i]=50;
            oip_possessed[i]=50;
            oip_medium[i]=50;
            ocp[i]=50;
        }
    }

    //playerのwolfIPを返す．viewは0:Subjective, 1:Objective．
	public int getWolfPoint(int player,int view) {
        if(view==0){
            return sip_wolf[player];
        }else if(view==1){
            return oip_wolf[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
	}
	
    //playerのwolfIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
	public void setWolfPoint(int player,int view,int point){
        if(view==0){
            this.sip_wolf[player] = this.sip_wolf[player]+point;
        }else if(view==1){
            this.oip_wolf[player] = this.oip_wolf[player]+point;
        }
	}
    
    //playerのvillagerIPを返す．viewは0:Subjective, 1:Objective．
    public int getVillagerPoint(int player,int view) {
        if(view==0){
            return sip_villager[player];
        }else if(view==1){
            return oip_villager[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのvillagerIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setVillagerPoint(int player,int view,int point){
        if(view==0){
            this.sip_villager[player] = this.sip_villager[player]+point;
        }else if(view==1){
            this.oip_villager[player] = this.oip_villager[player]+point;
        }
    }
    
    //playerのbodyguradIPを返す．viewは0:Subjective, 1:Objective．
    public int getBodyguradPoint(int player,int view) {
        if(view==0){
            return sip_bodygurad[player];
        }else if(view==1){
            return oip_bodygurad[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのbodyguradIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setBodyguradPoint(int player,int view,int point){
        if(view==0){
            this.sip_bodygurad[player] = this.sip_bodygurad[player]+point;
        }else if(view==1){
            this.oip_bodygurad[player] = this.oip_bodygurad[player]+point;
        }
    }
    
    //playerのseerIPを返す．viewは0:Subjective, 1:Objective．
    public int getSeerPoint(int player,int view) {
        if(view==0){
            return sip_seer[player];
        }else if(view==1){
            return oip_seer[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのseerIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setSeerPoint(int player,int view,int point){
        if(view==0){
            this.sip_seer[player] = this.sip_seer[player]+point;
        }else if(view==1){
            this.oip_seer[player] = this.oip_seer[player]+point;
        }
    }
    
    //playerのpossessedIPを返す．viewは0:Subjective, 1:Objective．
    public int getPossessedPoint(int player,int view) {
        if(view==0){
            return sip_possessed[player];
        }else if(view==1){
            return oip_possessed[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのwolfIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setPossessedPoint(int player,int view,int point){
        if(view==0){
            this.sip_possessed[player] = this.sip_possessed[player]+point;
        }else if(view==1){
            this.oip_possessed[player] = this.oip_possessed[player]+point;
        }
    }
    
    //playerのmediumIPを返す．viewは0:Subjective, 1:Objective．
    public int getMediumPoint(int player,int view) {
        if(view==0){
            return sip_medium[player];
        }else if(view==1){
            return oip_medium[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのmediumIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setMediumPoint(int player,int view,int point){
        if(view==0){
            this.sip_medium[player] = this.sip_medium[player]+point;
        }else if(view==1){
            this.oip_medium[player] = this.oip_medium[player]+point;
        }
    }
    
    //playerのCPを返す．viewは0:Subjective, 1:Objective．
    public int getCampPoint(int player,int view) {
        if(view==0){
            return scp[player];
        }else if(view==1){
            return ocp[player];
        }else{//正しい値が入力されなかった場合
            return 0;
        }
    }
    
    //playerのCPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setCampPoint(int player,int view,int point){
        if(view==0){
            this.scp[player] = this.scp[player]+point;
        }else if(view==1){
            this.ocp[player] = this.ocp[player]+point;
        }
    }


}