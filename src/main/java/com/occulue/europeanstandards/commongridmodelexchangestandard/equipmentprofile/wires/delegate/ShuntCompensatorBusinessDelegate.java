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
 * ShuntCompensator business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ShuntCompensator related services in the case of a
 *       ShuntCompensator business related service failing.
 *   <li>Exposes a simpler, uniform ShuntCompensator interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ShuntCompensator business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ShuntCompensatorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ShuntCompensatorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ShuntCompensator Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ShuntCompensatorBusinessDelegate
   */
  public static ShuntCompensatorBusinessDelegate getShuntCompensatorInstance() {
    return (new ShuntCompensatorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createShuntCompensator(CreateShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getShuntCompensatorId() == null) command.setShuntCompensatorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateShuntCompensatorCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateShuntCompensatorCommand of ShuntCompensator is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ShuntCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateShuntCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateShuntCompensator(UpdateShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateShuntCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ShuntCompensator - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteShuntCompensatorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteShuntCompensatorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteShuntCompensatorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ShuntCompensator using Id = " + command.getShuntCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ShuntCompensator via ShuntCompensatorFetchOneSummary
   *
   * @param summary ShuntCompensatorFetchOneSummary
   * @return ShuntCompensatorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ShuntCompensator getShuntCompensator(ShuntCompensatorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ShuntCompensatorFetchOneSummary arg cannot be null");

    ShuntCompensator entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ShuntCompensator
      // --------------------------------------
      CompletableFuture<ShuntCompensator> futureEntity =
          queryGateway.query(
              new FindShuntCompensatorQuery(
                  new LoadShuntCompensatorFilter(summary.getShuntCompensatorId())),
              ResponseTypes.instanceOf(ShuntCompensator.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ShuntCompensator with id " + summary.getShuntCompensatorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ShuntCompensators
   *
   * @return List<ShuntCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ShuntCompensator> getAllShuntCompensator() throws ProcessingException {
    List<ShuntCompensator> list = null;

    try {
      CompletableFuture<List<ShuntCompensator>> futureList =
          queryGateway.query(
              new FindAllShuntCompensatorQuery(),
              ResponseTypes.multipleInstancesOf(ShuntCompensator.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ShuntCompensator";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign AVRDelay on ShuntCompensator
   *
   * @param command AssignAVRDelayToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignAVRDelay(AssignAVRDelayToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign AVRDelay on ShuntCompensator
   *
   * @param command UnAssignAVRDelayFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignAVRDelay(UnAssignAVRDelayFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign AVRDelay on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Grounded on ShuntCompensator
   *
   * @param command AssignGroundedToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignGrounded(AssignGroundedToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Grounded on ShuntCompensator
   *
   * @param command UnAssignGroundedFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignGrounded(UnAssignGroundedFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Grounded on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaximumSections on ShuntCompensator
   *
   * @param command AssignMaximumSectionsToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignMaximumSections(AssignMaximumSectionsToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaximumSections on ShuntCompensator
   *
   * @param command UnAssignMaximumSectionsFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignMaximumSections(UnAssignMaximumSectionsFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaximumSections on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NomU on ShuntCompensator
   *
   * @param command AssignNomUToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignNomU(AssignNomUToShuntCompensatorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

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
   * unAssign NomU on ShuntCompensator
   *
   * @param command UnAssignNomUFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignNomU(UnAssignNomUFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NomU on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NormalSections on ShuntCompensator
   *
   * @param command AssignNormalSectionsToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignNormalSections(AssignNormalSectionsToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NormalSections on ShuntCompensator
   *
   * @param command UnAssignNormalSectionsFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignNormalSections(UnAssignNormalSectionsFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NormalSections on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SwitchOnCount on ShuntCompensator
   *
   * @param command AssignSwitchOnCountToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignSwitchOnCount(AssignSwitchOnCountToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SwitchOnCount on ShuntCompensator
   *
   * @param command UnAssignSwitchOnCountFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignSwitchOnCount(UnAssignSwitchOnCountFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SwitchOnCount on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SwitchOnDate on ShuntCompensator
   *
   * @param command AssignSwitchOnDateToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignSwitchOnDate(AssignSwitchOnDateToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateTimeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateTimeBusinessDelegate.getDateTimeInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getDateTimeId();
    DateTime child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateTime using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SwitchOnDate on ShuntCompensator
   *
   * @param command UnAssignSwitchOnDateFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignSwitchOnDate(UnAssignSwitchOnDateFromShuntCompensatorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SwitchOnDate on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VoltageSensitivity on ShuntCompensator
   *
   * @param command AssignVoltageSensitivityToShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void assignVoltageSensitivity(AssignVoltageSensitivityToShuntCompensatorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getShuntCompensatorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltagePerReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance();
    ShuntCompensatorBusinessDelegate parentDelegate =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();
    UUID childId = command.getAssignment().getVoltagePerReactivePowerId();
    VoltagePerReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get VoltagePerReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign VoltageSensitivity on ShuntCompensator
   *
   * @param command UnAssignVoltageSensitivityFromShuntCompensatorCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageSensitivity(
      UnAssignVoltageSensitivityFromShuntCompensatorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ShuntCompensatorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageSensitivity on ShuntCompensator";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ShuntCompensator
   */
  private ShuntCompensator load(UUID id) throws ProcessingException {
    shuntCompensator =
        ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
            .getShuntCompensator(new ShuntCompensatorFetchOneSummary(id));
    return shuntCompensator;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ShuntCompensator shuntCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(ShuntCompensatorBusinessDelegate.class.getName());
}
