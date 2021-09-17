package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.SystemMessage.ID_MESSAGE;


/**
 * 入力データ
 * @author hayakawa
 */
public class InputData{
    /**
     * 文字列入力(必須/最大文字数)
     * @param idMessage ID_MESSAGE メッセージID
     * @param maxLength int 最大文字数
     * @return String 入力データ
     * @throws BusinessException 業務例外
     */
    public String inputString(ID_MESSAGE idMessage, int maxLength) throws BusinessException{
        // 入力データ
        String inputData = null;
        
        try{
            // 引数チェック
            if(maxLength < 1){
                throw new BusinessException(SystemMessage.getMessage(ID_MESSAGE.E0001));
            }
            
            // 入力バッファ生成
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            // 入力ループ
            while(true){
                // メッセージ出力
                SystemMessage.outMessage(idMessage);
                
                // 1行入力
                String inputStr = bufferedReader.readLine();
                
                // 入力チェック
                if(inputStr != null && !inputStr.isEmpty()
                        && inputStr.length() <= maxLength){
                    // 入力OK
                    inputData = inputStr;
                    break;
                }
            }
        // ***** 例外処理 *****
        }catch(IOException objExp){
            // 入出力例外
            throw new BusinessException(SystemMessage.getMessage(ID_MESSAGE.E0002));
        }
        
        return inputData;
    }

    /**
     * 数値入力(最小数指定)
     * @param idMessage ID_MESSAGE メッセージID
     * @param min int 最小数
     * @return int 入力データ
     * @throws BusinessException 業務例外
     */
    public int inputInt(ID_MESSAGE idMessage, int min) throws BusinessException{
        // 入力データ
        int inputData = 0;
        
        try{
            // 入力バッファ生成
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            // 入力ループ
            while(true){
                try{
                    // メッセージ出力
                    SystemMessage.outMessage(idMessage);
                    
                    // 1行入力
                    String inputStr = bufferedReader.readLine();
                    
                    // 数字を数値に変換
                    int inputInt = Integer.parseInt(inputStr);
                    
                    // 入力チェック
                    if(inputInt >= min){
                        // 入力OK
                        inputData = inputInt;
                        break;
                    }
                    // ***** 例外処理 *****
                }catch(NumberFormatException objExp){
                    // int変換例外
                    throw new BusinessException(SystemMessage.getMessage(ID_MESSAGE.E0002));
                }
            }
        // ***** 例外処理 *****
        }catch(IOException objExp){
            // 入出力例外
            throw new BusinessException(SystemMessage.getMessage(ID_MESSAGE.E0002));
        }
        
        return inputData;
    }

    /**
     * 数値入力(範囲指定)
     * @param idMessage ID_MESSAGE メッセージID
     * @param from int 最小数
     * @param to int 最大数
     * @return int 入力データ
     * @throws BusinessException 業務例外
     */
    public int inputInt(ID_MESSAGE idMessage, int from, int to) throws BusinessException{
        // 入力データ
        int inputData = 0;
        
        // 入力ループ
        while(true){
            // 数値入力(最小数指定)
        	int inputInt = this.inputInt(idMessage, from);
        	
            // 入力チェック
            if(inputInt <= to){
                // 入力OK
                inputData = inputInt;
                break;
            }
        }
        
        return inputData;
    }
}
