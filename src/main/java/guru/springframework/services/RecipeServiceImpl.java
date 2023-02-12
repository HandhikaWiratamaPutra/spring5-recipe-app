package guru.springframework.services;

import guru.springframework.Repositories.RecipeRepository;
import guru.springframework.domain.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Im in the service");
        Set<Recipe> recipeSet = new HashSet<>();
//        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        recipeRepository.findAll().iterator().forEachRemaining(recipe -> recipeSet.add(recipe));
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional <Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }
}
