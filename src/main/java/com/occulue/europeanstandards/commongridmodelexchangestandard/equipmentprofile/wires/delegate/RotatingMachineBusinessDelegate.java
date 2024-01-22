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
 * RotatingMachine business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RotatingMachine related services in the case of a
 *       RotatingMachine business related service failing.
 *   <li>Exposes a simpler, uniform RotatingMachine interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RotatingMachine business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RotatingMachineBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RotatingMachineBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RotatingMachine Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RotatingMachineBusinessDelegate
   */
  public static RotatingMachineBusinessDelegate getRotatingMachineInstance() {
    return (new RotatingMachineBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRotatingMachine(CreateRotatingMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRotatingMachineId() == null) command.setRotatingMachineId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRotatingMachineCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRotatingMachineCommand of RotatingMachine is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RotatingMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRotatingMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRotatingMachine(UpdateRotatingMachineCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRotatingMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RotatingMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRotatingMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRotatingMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRotatingMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RotatingMachine using Id = " + command.getRotatingMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RotatingMachine via RotatingMachineFetchOneSummary
   *
   * @param summary RotatingMachineFetchOneSummary
   * @return RotatingMachineFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RotatingMachine getRotatingMachine(RotatingMachineFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RotatingMachineFetchOneSummary arg cannot be null");

    RotatingMachine entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RotatingMachine
      // --------------------------------------
      CompletableFuture<RotatingMachine> futureEntity =
          queryGateway.query(
              new FindRotatingMachineQuery(
                  new LoadRotatingMachineFilter(summary.getRotatingMachineId())),
              ResponseTypes.instanceOf(RotatingMachine.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RotatingMachine with id " + summary.getRotatingMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RotatingMachines
   *
   * @return List<RotatingMachine>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RotatingMachine> getAllRotatingMachine() throws ProcessingException {
    List<RotatingMachine> list = null;

    try {
      CompletableFuture<List<RotatingMachine>> futureList =
          queryGateway.query(
              new FindAllRotatingMachineQuery(),
              ResponseTypes.multipleInstancesOf(RotatingMachine.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RotatingMachine";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign RatedPowerFactor on RotatingMachine
   *
   * @param command AssignRatedPowerFactorToRotatingMachineCommand
   * @exception ProcessingException
   */
  public void assignRatedPowerFactor(AssignRatedPowerFactorToRotatingMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    RotatingMachineBusinessDelegate parentDelegate =
        RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedPowerFactor on RotatingMachine
   *
   * @param command UnAssignRatedPowerFactorFromRotatingMachineCommand
   * @exception ProcessingException
   */
  public void unAssignRatedPowerFactor(UnAssignRatedPowerFactorFromRotatingMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedPowerFactor on RotatingMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedS on RotatingMachine
   *
   * @param command AssignRatedSToRotatingMachineCommand
   * @exception ProcessingException
   */
  public void assignRatedS(AssignRatedSToRotatingMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ApparentPowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ApparentPowerBusinessDelegate.getApparentPowerInstance();
    RotatingMachineBusinessDelegate parentDelegate =
        RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    UUID childId = command.getAssignment().getApparentPowerId();
    ApparentPower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ApparentPower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedS on RotatingMachine
   *
   * @param command UnAssignRatedSFromRotatingMachineCommand
   * @exception ProcessingException
   */
  public void unAssignRatedS(UnAssignRatedSFromRotatingMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedS on RotatingMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedU on RotatingMachine
   *
   * @param command AssignRatedUToRotatingMachineCommand
   * @exception ProcessingException
   */
  public void assignRatedU(AssignRatedUToRotatingMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    RotatingMachineBusinessDelegate parentDelegate =
        RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedU on RotatingMachine
   *
   * @param command UnAssignRatedUFromRotatingMachineCommand
   * @exception ProcessingException
   */
  public void unAssignRatedU(UnAssignRatedUFromRotatingMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedU on RotatingMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add RotatingMachine to RotatingMachine
   *
   * @param command AssignRotatingMachineToRotatingMachineCommand
   * @exception ProcessingException
   */
  public void addToRotatingMachine(AssignRotatingMachineToRotatingMachineCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getRotatingMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RotatingMachineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    RotatingMachineBusinessDelegate parentDelegate =
        RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    UUID childId = command.getAddTo().getRotatingMachineId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a RotatingMachine as RotatingMachine to RotatingMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove RotatingMachine from RotatingMachine
   *
   * @param command RemoveRotatingMachineFromRotatingMachineCommand
   * @exception ProcessingException
   */
  public void removeFromRotatingMachine(RemoveRotatingMachineFromRotatingMachineCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RotatingMachineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RotatingMachineBusinessDelegate.getRotatingMachineInstance();
    UUID childId = command.getRemoveFrom().getRotatingMachineId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineValidator.getInstance().validate(command);

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
   * @return RotatingMachine
   */
  private RotatingMachine load(UUID id) throws ProcessingException {
    rotatingMachine =
        RotatingMachineBusinessDelegate.getRotatingMachineInstance()
            .getRotatingMachine(new RotatingMachineFetchOneSummary(id));
    return rotatingMachine;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RotatingMachine rotatingMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineBusinessDelegate.class.getName());
}
