using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;


namespace CameraCaptureTaskSmaple
{
    public partial class MainPage : PhoneApplicationPage
    {
        //CameraCaptureTask
        CameraCaptureTask mCameraCaptureTask;

        // コンストラクター
        public MainPage()
        {
            InitializeComponent();

            // CameraCaptureTaskのNew
            mCameraCaptureTask = new CameraCaptureTask();

            // Complete時の処理を設定
            mCameraCaptureTask.Completed += new EventHandler<PhotoResult>(mCameraCaptureTask_Completed);

        
        }

        /**
         * CaptureTaskのCompleted-Eventに登録するMethod
         * 
         */
        void mCameraCaptureTask_Completed(object sender, PhotoResult e)
        {
            // Resultのチェック
            if (e.TaskResult == TaskResult.OK && e.ChosenPhoto != null)
            {
                // カメラで撮影した画像が取得できた
                
                // imageに表示するBitmapを作成する
                BitmapImage bmp = new BitmapImage();
                bmp.SetSource(e.ChosenPhoto);
                image1.Source = bmp;

            }
            else if (e.TaskResult == TaskResult.Cancel)
            {
                // userによるキャンセル時
            }
            else if(e.TaskResult == TaskResult.None || e.ChosenPhoto == null)
            {
                // 取得失敗
            }
        }


        /**
         * Button押下時に呼び出される
         * Camera機能を呼び出す
         */
        private void button1_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                mCameraCaptureTask.Show();
            }
            catch (InvalidOperationException ioe)
            {
                // error
            }
        }
    }
}