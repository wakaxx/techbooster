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
using System.Windows.Shapes;
using Microsoft.Phone.Controls;
using System.IO.IsolatedStorage;
using System.IO;


namespace PhoneApp1
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
        }

        
        private void save_button_Click(object sender, RoutedEventArgs e)
        {
            // textデータを取得
            string title = titleBox.Text;
            string text = textBox1.Text;

            // 分離ストレージを取得
            IsolatedStorageFile isoStorage = IsolatedStorageFile.GetUserStoreForApplication();

            try
            {
                // 分離ストレージからFileStreamを取得
                IsolatedStorageFileStream stream = isoStorage.OpenFile(title, FileMode.Create);
                StreamWriter sw = new StreamWriter(stream, System.Text.Encoding.UTF8);

                // 書き込み
                sw.Write(text);

                // streamのclose
                sw.Close();
                stream.Close();

            }
            catch (IOException ioe)
            {

            }


        }

        private void show_button_Click(object sender, RoutedEventArgs e)
        {
            // textデータを取得
            string title = titleBox.Text;
            string line = null;

            // 分離ストレージを取得
            IsolatedStorageFile isoStorage = IsolatedStorageFile.GetUserStoreForApplication();

            try
            {
                // 分離ストレージからFileStreamを取得
                IsolatedStorageFileStream stream = isoStorage.OpenFile(title, FileMode.Open);
                StreamReader sr = new StreamReader(stream, System.Text.Encoding.UTF8);

                //sr = new StreamReader(IsolatedStorageFile.GetUserStoreForApplication().OpenFile(title, FileMode.Open), System.Text.Encoding.UTF8);


                //textBoxの内容をクリア
                textBox1.Text = "";

                // 読み出し
                while ((line = sr.ReadLine()) != null)
                {
                    textBox1.Text = textBox1.Text + line;
                }

                sr.Close();
                stream.Close();

            }
            catch (IsolatedStorageException ie)
            {
                textBox1.Text = "file not found!!";

            }
        }
    }
}