package com.cookandroid.linc_sadaju.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cookandroid.linc_sadaju.databinding.FragmentChatBinding;

public class ChatFragment extends Fragment {

    private FragmentChatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChatViewModel chatViewModel =
                new ViewModelProvider(this).get(ChatViewModel.class);

        binding = FragmentChatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textChat;

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}