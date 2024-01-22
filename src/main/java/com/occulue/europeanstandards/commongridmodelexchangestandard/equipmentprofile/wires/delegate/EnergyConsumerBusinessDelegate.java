/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * EnergyConsumer business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of EnergyConsumer related services in the case of a EnergyConsumer
 *       business related service failing.
 *   <li>Exposes a simpler, uniform EnergyConsumer interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill EnergyConsumer business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class EnergyConsumerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public EnergyConsumerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * EnergyConsumer Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return EnergyConsumerBusinessDelegate
   */
  public static EnergyConsumerBusinessDelegate getEnergyConsumerInstance() {
    return (new EnergyConsumerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createEnergyConsumer(CreateEnergyConsumerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getEnergyConsumerId() == null) command.setEnergyConsumerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateEnergyConsumerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateEnergyConsumerCommand of EnergyConsumer is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create EnergyConsumer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateEnergyConsumerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateEnergyConsumer(UpdateEnergyConsumerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateEnergyConsumerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save EnergyConsumer - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteEnergyConsumerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteEnergyConsumerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteEnergyConsumerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete EnergyConsumer using Id = " + command.getEnergyConsumerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the EnergyConsumer via EnergyConsumerFetchOneSummary
   *
   * @param summary EnergyConsumerFetchOneSummary
   * @return EnergyConsumerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public EnergyConsumer getEnergyConsumer(EnergyConsumerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("EnergyConsumerFetchOneSummary arg cannot be null");

    EnergyConsumer entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a EnergyConsumer
      // --------------------------------------
      CompletableFuture<EnergyConsumer> futureEntity =
          queryGateway.query(
              new FindEnergyConsumerQuery(
                  new LoadEnergyConsumerFilter(summary.getEnergyConsumerId())),
              ResponseTypes.instanceOf(EnergyConsumer.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate EnergyConsumer with id " + summary.getEnergyConsumerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all EnergyConsumers
   *
   * @return List<EnergyConsumer>
   * @exception ProcessingException Thrown if any problems
   */
  public List<EnergyConsumer> getAllEnergyConsumer() throws ProcessingException {
    List<EnergyConsumer> list = null;

    try {
      CompletableFuture<List<EnergyConsumer>> futureList =
          queryGateway.query(
              new FindAllEnergyConsumerQuery(),
              ResponseTypes.multipleInstancesOf(EnergyConsumer.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all EnergyConsumer";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Pfixed on EnergyConsumer
   *
   * @param command AssignPfixedToEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void assignPfixed(AssignPfixedToEnergyConsumerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEnergyConsumerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    EnergyConsumerBusinessDelegate parentDelegate =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Pfixed on EnergyConsumer
   *
   * @param command UnAssignPfixedFromEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void unAssignPfixed(UnAssignPfixedFromEnergyConsumerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pfixed on EnergyConsumer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PfixedPct on EnergyConsumer
   *
   * @param command AssignPfixedPctToEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void assignPfixedPct(AssignPfixedPctToEnergyConsumerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEnergyConsumerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    EnergyConsumerBusinessDelegate parentDelegate =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign PfixedPct on EnergyConsumer
   *
   * @param command UnAssignPfixedPctFromEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void unAssignPfixedPct(UnAssignPfixedPctFromEnergyConsumerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PfixedPct on EnergyConsumer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qfixed on EnergyConsumer
   *
   * @param command AssignQfixedToEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void assignQfixed(AssignQfixedToEnergyConsumerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEnergyConsumerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    EnergyConsumerBusinessDelegate parentDelegate =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Qfixed on EnergyConsumer
   *
   * @param command UnAssignQfixedFromEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void unAssignQfixed(UnAssignQfixedFromEnergyConsumerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qfixed on EnergyConsumer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QfixedPct on EnergyConsumer
   *
   * @param command AssignQfixedPctToEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void assignQfixedPct(AssignQfixedPctToEnergyConsumerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEnergyConsumerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    EnergyConsumerBusinessDelegate parentDelegate =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign QfixedPct on EnergyConsumer
   *
   * @param command UnAssignQfixedPctFromEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void unAssignQfixedPct(UnAssignQfixedPctFromEnergyConsumerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QfixedPct on EnergyConsumer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add EnergyConsumer to EnergyConsumer
   *
   * @param command AssignEnergyConsumerToEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void addToEnergyConsumer(AssignEnergyConsumerToEnergyConsumerCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getEnergyConsumerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .EnergyConsumerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    EnergyConsumerBusinessDelegate parentDelegate =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getAddTo().getEnergyConsumerId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a EnergyConsumer as EnergyConsumer to EnergyConsumer";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove EnergyConsumer from EnergyConsumer
   *
   * @param command RemoveEnergyConsumerFromEnergyConsumerCommand
   * @exception ProcessingException
   */
  public void removeFromEnergyConsumer(RemoveEnergyConsumerFromEnergyConsumerCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .EnergyConsumerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();
    UUID childId = command.getRemoveFrom().getEnergyConsumerId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergyConsumerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return EnergyConsumer
   */
  private EnergyConsumer load(UUID id) throws ProcessingException {
    energyConsumer =
        EnergyConsumerBusinessDelegate.getEnergyConsumerInstance()
            .getEnergyConsumer(new EnergyConsumerFetchOneSummary(id));
    return energyConsumer;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private EnergyConsumer energyConsumer = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergyConsumerBusinessDelegate.class.getName());
}
