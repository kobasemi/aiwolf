package jp.ac.kansai_u.kutc.firefly.aiwolf;



/**
 * This class manage detail of agentpoint.
 *
 * @author Yuki Nojima
 */
public class AgentPoint {
    private int sip_wolf[] = new int[15];
    private int sip_villager[] = new int[15];
    private int sip_bodyguard[] = new int[15];
    private int sip_seer[] = new int[15];
    private int sip_possessed[] = new int[15];
    private int sip_medium[] = new int[15];
    private int scp[] = new int[15];

    private int oip_wolf[] = new int[15];
    private int oip_villager[] = new int[15];
    private int oip_bodyguard[] = new int[15];
    private int oip_seer[] = new int[15];
    private int oip_possessed[] = new int[15];
    private int oip_medium[] = new int[15];
    private int ocp[] = new int[15];

    public AgentPoint(){
        for(int i=0;i<15;i++){
            sip_wolf[i]=50;
            sip_villager[i]=50;
            sip_bodyguard[i]=50;
            sip_seer[i]=50;
            sip_possessed[i]=50;
            sip_medium[i]=50;
            scp[i]=50;

            oip_wolf[i]=50;
            oip_villager[i]=50;
            oip_bodyguard[i]=50;
            oip_seer[i]=50;
            oip_possessed[i]=50;
            oip_medium[i]=50;
            ocp[i]=50;
        }
    }

    //playerのwolfIPを返す．viewは0:Subjective, 1:Objective．
	public int getWolfPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_wolf[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_wolf[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
	}

    //playerのwolfIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
	public void setWolfPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_wolf[player] = this.sip_wolf[player]+point;
            if(this.sip_wolf[player]<0){
                this.sip_wolf[player]=0;
            }else if(this.sip_wolf[player]>=100){
                this.sip_wolf[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_wolf[player] = this.oip_wolf[player]+point;
            if(this.oip_wolf[player]<0){
                this.oip_wolf[player]=0;
            }else if(this.oip_wolf[player]>=100){
                this.oip_wolf[player]=99;
            }
        }
	}

    //playerのvillagerIPを返す．viewは0:Subjective, 1:Objective．
    public int getVillagerPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_villager[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_villager[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのvillagerIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setVillagerPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_villager[player] = this.sip_villager[player]+point;
            if(this.sip_villager[player]<0){
                this.sip_villager[player]=0;
            }else if(this.sip_villager[player]>=100){
                this.sip_villager[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_villager[player] = this.oip_villager[player]+point;
            if(this.oip_villager[player]<0){
                this.oip_villager[player]=0;
            }else if(this.oip_villager[player]>=100){
                this.oip_villager[player]=99;
            }
        }
    }

    //playerのbodyguardIPを返す．viewは0:Subjective, 1:Objective．
    public int getBodyguardPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_bodyguard[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_bodyguard[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのbodyguardIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setBodyguardPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_bodyguard[player] = this.sip_bodyguard[player]+point;
            if(this.sip_bodyguard[player]<0){
                this.sip_bodyguard[player]=0;
            }else if(this.sip_bodyguard[player]>=100){
                this.sip_bodyguard[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_bodyguard[player] = this.oip_bodyguard[player]+point;
            if(this.oip_bodyguard[player]<0){
                this.oip_bodyguard[player]=0;
            }else if(this.oip_bodyguard[player]>=100){
                this.oip_bodyguard[player]=99;
            }
        }
    }

    //playerのseerIPを返す．viewは0:Subjective, 1:Objective．
    public int getSeerPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_seer[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_seer[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのseerIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setSeerPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_seer[player] = this.sip_seer[player]+point;
            if(this.sip_seer[player]<0){
                this.sip_seer[player]=0;
            }else if(this.sip_seer[player]>=100){
                this.sip_seer[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_seer[player] = this.oip_seer[player]+point;
            if(this.oip_seer[player]<0){
                this.oip_seer[player]=0;
            }else if(this.oip_seer[player]>=100){
                this.oip_seer[player]=99;
            }
        }
    }

    //playerのpossessedIPを返す．viewは0:Subjective, 1:Objective．
    public int getPossessedPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_possessed[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_possessed[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのwolfIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setPossessedPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_possessed[player] = this.sip_possessed[player]+point;
            if(this.sip_possessed[player]<0){
                this.sip_possessed[player]=0;
            }else if(this.sip_possessed[player]>=100){
                this.sip_possessed[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_possessed[player] = this.oip_possessed[player]+point;
            if(this.oip_possessed[player]<0){
                this.oip_possessed[player]=0;
            }else if(this.oip_possessed[player]>=100){
                this.oip_possessed[player]=99;
            }
        }
    }

    //playerのmediumIPを返す．viewは0:Subjective, 1:Objective．
    public int getMediumPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return sip_medium[player];
        }else if(view.equals(View.OBJECTIVE)){
            return oip_medium[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのmediumIPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setMediumPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.sip_medium[player] = this.sip_medium[player]+point;
            if(this.sip_medium[player]<0){
                this.sip_medium[player]=0;
            }else if(this.sip_medium[player]>=100){
                this.sip_medium[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.oip_medium[player] = this.oip_medium[player]+point;
            if(this.oip_medium[player]<0){
                this.oip_medium[player]=0;
            }else if(this.oip_medium[player]>=100){
                this.oip_medium[player]=99;
            }
        }
    }

    //playerのCPを返す．viewは0:Subjective, 1:Objective．
    public int getCampPoint(int player,View view) {
        if(view.equals(View.SUBJECTIVE)){
            return scp[player];
        }else if(view.equals(View.OBJECTIVE)){
            return ocp[player];
        }else{//正しい値が入力されなかった場合
            return -1;
        }
    }

    //playerのCPをpoint分プラスする．viewは0:Subjective, 1:Objective．
    public void setCampPoint(int player,View view,int point){
        if(view.equals(View.SUBJECTIVE)){
            this.scp[player] = this.scp[player]+point;
            if(this.scp[player]<0){
                this.scp[player]=0;
            }else if(this.scp[player]>=100){
                this.scp[player]=99;
            }
        }else if(view.equals(View.OBJECTIVE)){
            this.ocp[player] = this.ocp[player]+point;
            if(this.ocp[player]<0){
                this.ocp[player]=0;
            }else if(this.ocp[player]>=100){
                this.ocp[player]=99;
            }
        }
    }


}