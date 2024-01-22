package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for LoadGroup as outlined for the CQRS pattern, all write responsibilities
 * related to LoadGroup are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadGroupAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadGroupAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadGroupAggregate(CreateLoadGroupCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadGroupCommand");
    CreateLoadGroupEvent event = new CreateLoadGroupEvent(command.getLoadGroupId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadGroupCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadGroupCommand");
    UpdateLoadGroupEvent event =
        new UpdateLoadGroupEvent(command.getLoadGroupId(), command.getLoadGroups());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadGroupCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadGroupCommand");
    apply(new DeleteLoadGroupEvent(command.getLoadGroupId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignLoadGroupsToLoadGroupCommand command) throws Exception {
    LOGGER.info("Handling command AssignLoadGroupsToLoadGroupCommand");

    if (loadGroups.contains(command.getAddTo()))
      throw new ProcessingException(
          "LoadGroups already contains an entity with id " + command.getAddTo().getLoadGroupId());

    apply(new AssignLoadGroupsToLoadGroupEvent(command.getLoadGroupId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLoadGroupsFromLoadGroupCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLoadGroupsFromLoadGroupCommand");

    if (!loadGroups.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "LoadGroups does not contain an entity with id "
              + command.getRemoveFrom().getLoadGroupId());

    apply(
        new RemoveLoadGroupsFromLoadGroupEvent(command.getLoadGroupId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadGroupEvent event) {
    LOGGER.info("Event sourcing CreateLoadGroupEvent");
    this.loadGroupId = event.getLoadGroupId();
  }

  @EventSourcingHandler
  void on(UpdateLoadGroupEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.loadGroups = event.getLoadGroups();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignLoadGroupsToLoadGroupEvent event) {
    LOGGER.info("Event sourcing AssignLoadGroupsToLoadGroupEvent");
    this.loadGroups.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLoadGroupsFromLoadGroupEvent event) {
    LOGGER.info("Event sourcing RemoveLoadGroupsFromLoadGroupEvent");
    this.loadGroups.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadGroupId;

  private Set<LoadGroup> loadGroups = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(LoadGroupAggregate.class.getName());
}
