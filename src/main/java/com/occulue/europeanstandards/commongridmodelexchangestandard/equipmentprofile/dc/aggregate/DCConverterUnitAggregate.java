package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for DCConverterUnit as outlined for the CQRS pattern, all write
 * responsibilities related to DCConverterUnit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCConverterUnitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCConverterUnitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCConverterUnitAggregate(CreateDCConverterUnitCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCConverterUnitCommand");
    CreateDCConverterUnitEvent event =
        new CreateDCConverterUnitEvent(command.getDCConverterUnitId(), command.getOperationMode());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCConverterUnitCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCConverterUnitCommand");
    UpdateDCConverterUnitEvent event =
        new UpdateDCConverterUnitEvent(
            command.getDCConverterUnitId(),
            command.getOperationMode(),
            command.getDCConverterUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCConverterUnitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCConverterUnitCommand");
    apply(new DeleteDCConverterUnitEvent(command.getDCConverterUnitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCConverterUnitToDCConverterUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCConverterUnitToDCConverterUnitCommand");

    if (dCConverterUnit.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCConverterUnit already contains an entity with id "
              + command.getAddTo().getDCConverterUnitId());

    apply(
        new AssignDCConverterUnitToDCConverterUnitEvent(
            command.getDCConverterUnitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCConverterUnitFromDCConverterUnitCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCConverterUnitFromDCConverterUnitCommand");

    if (!dCConverterUnit.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCConverterUnit does not contain an entity with id "
              + command.getRemoveFrom().getDCConverterUnitId());

    apply(
        new RemoveDCConverterUnitFromDCConverterUnitEvent(
            command.getDCConverterUnitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCConverterUnitEvent event) {
    LOGGER.info("Event sourcing CreateDCConverterUnitEvent");
    this.dCConverterUnitId = event.getDCConverterUnitId();
    this.operationMode = event.getOperationMode();
  }

  @EventSourcingHandler
  void on(UpdateDCConverterUnitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.operationMode = event.getOperationMode();
    this.dCConverterUnit = event.getDCConverterUnit();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCConverterUnitToDCConverterUnitEvent event) {
    LOGGER.info("Event sourcing AssignDCConverterUnitToDCConverterUnitEvent");
    this.dCConverterUnit.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCConverterUnitFromDCConverterUnitEvent event) {
    LOGGER.info("Event sourcing RemoveDCConverterUnitFromDCConverterUnitEvent");
    this.dCConverterUnit.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCConverterUnitId;

  private DCConverterOperatingModeKind operationMode;
  private Set<DCConverterUnit> dCConverterUnit = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCConverterUnitAggregate.class.getName());
}
