package common;
/**
 * 業務例外
 * @author hayakawa
 */
public class BusinessException extends Exception{
    // ***** 定数 *****
    // シリアルバージョン
    private static final long serialVersionUID = 1L;
    // 処理状態
    public static enum ST_PROC{
        ST_NORMAL          // 正常(処理継続)
      , ST_WARNING         // 警告(処理継続)
      , ST_BUSINESS_ERROR  // 業務エラー(処理中断)
      , ST_SYSTEM_ERROR    // システムエラー(処理中断)
    ;}

    // ***** メンバ変数 *****
    // 処理状態
    private ST_PROC stProc = ST_PROC.ST_NORMAL;

    /**
     * コンストラクタ
     * @param message String メッセージ
     */
    public BusinessException(String message){
        super(message);
        this.stProc = ST_PROC.ST_SYSTEM_ERROR;
    }

    /**
     * コンストラクタ
     * @param stProc ST_PROC 処理状態
     * @param message String メッセージ
     */
    public BusinessException(ST_PROC stProc, String message){
        super(message);
        this.stProc = stProc;
    }

    /**
     * 処理状態取得
     * @return ST_PROC 処理状態
     */
    public ST_PROC getStProc(){
        return this.stProc;
    }
}
