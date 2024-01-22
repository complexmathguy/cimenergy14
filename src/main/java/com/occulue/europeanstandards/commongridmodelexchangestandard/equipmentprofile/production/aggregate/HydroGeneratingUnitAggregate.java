package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.aggregate;

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
 * Aggregate handler for HydroGeneratingUnit as outlined for the CQRS pattern, all write
 * responsibilities related to HydroGeneratingUnit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class HydroGeneratingUnitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public HydroGeneratingUnitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public HydroGeneratingUnitAggregate(CreateHydroGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command CreateHydroGeneratingUnitCommand");
    CreateHydroGeneratingUnitEvent event =
        new CreateHydroGeneratingUnitEvent(
            command.getHydroGeneratingUnitId(), command.getEnergyConversionCapability());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateHydroGeneratingUnitCommand command) throws Exception {
    LOGGER.info("handling command UpdateHydroGeneratingUnitCommand");
    UpdateHydroGeneratingUnitEvent event =
        new UpdateHydroGeneratingUnitEvent(
            command.getHydroGeneratingUnitId(),
            command.getEnergyConversionCapability(),
            command.getHydroGeneratingUnits());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteHydroGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteHydroGeneratingUnitCommand");
    apply(new DeleteHydroGeneratingUnitEvent(command.getHydroGeneratingUnitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignHydroGeneratingUnitsToHydroGeneratingUnitCommand");

    if (hydroGeneratingUnits.contains(command.getAddTo()))
      throw new ProcessingException(
          "HydroGeneratingUnits already contains an entity with id "
              + command.getAddTo().getHydroGeneratingUnitId());

    apply(
        new AssignHydroGeneratingUnitsToHydroGeneratingUnitEvent(
            command.getHydroGeneratingUnitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveHydroGeneratingUnitsFromHydroGeneratingUnitCommand");

    if (!hydroGeneratingUnits.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "HydroGeneratingUnits does not contain an entity with id "
              + command.getRemoveFrom().getHydroGeneratingUnitId());

    apply(
        new RemoveHydroGeneratingUnitsFromHydroGeneratingUnitEvent(
            command.getHydroGeneratingUnitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateHydroGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing CreateHydroGeneratingUnitEvent");
    this.hydroGeneratingUnitId = event.getHydroGeneratingUnitId();
    this.energyConversionCapability = event.getEnergyConversionCapability();
  }

  @EventSourcingHandler
  void on(UpdateHydroGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.energyConversionCapability = event.getEnergyConversionCapability();
    this.hydroGeneratingUnits = event.getHydroGeneratingUnits();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignHydroGeneratingUnitsToHydroGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignHydroGeneratingUnitsToHydroGeneratingUnitEvent");
    this.hydroGeneratingUnits.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveHydroGeneratingUnitsFromHydroGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing RemoveHydroGeneratingUnitsFromHydroGeneratingUnitEvent");
    this.hydroGeneratingUnits.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID hydroGeneratingUnitId;

  private HydroEnergyConversionKind energyConversionCapability;
  private Set<HydroGeneratingUnit> hydroGeneratingUnits = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(HydroGeneratingUnitAggregate.class.getName());
}
