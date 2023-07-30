package learning.android.learning_listview_in_android.CountryEx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import learning.android.learning_listview_in_android.CountryModelClass;
import learning.android.learning_listview_in_android.R;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {

   private ArrayList<CountryModelClass> countryArrayList;
   Context context;


   public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CountryModelClass> countryArrayList, ArrayList<CountryModelClass> arrayList) {
       super(context, R.layout.item_list_layout, countryArrayList);
       this.countryArrayList = countryArrayList;
       this.context = context;
   }


   //View lookup cache
    private static class ViewHolder {
       TextView txt_countryName;
       TextView txt_CupWinCount;
       ImageView img_countryFlag;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     // get the data item for this position
        CountryModelClass countryModelClass = getItem(position);
        // check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout, parent, false);
            viewHolder.txt_countryName = (TextView) convertView.findViewById(R.id.countryName);
            viewHolder.txt_CupWinCount = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.img_countryFlag = (ImageView) convertView.findViewById(R.id.countryImage);
            result = convertView;
            convertView.setTag(viewHolder);
    }else{
        viewHolder = (ViewHolder) convertView.getTag();
        result = convertView;
        }

   // Get data from model class
        assert countryModelClass != null;
        viewHolder.txt_countryName.setText(countryModelClass.getCountryName());
        viewHolder.txt_CupWinCount.setText(countryModelClass.getCup_win_count());
        viewHolder.img_countryFlag.setImageResource(countryModelClass.getCountryFlag());

        return convertView;


   }
}
