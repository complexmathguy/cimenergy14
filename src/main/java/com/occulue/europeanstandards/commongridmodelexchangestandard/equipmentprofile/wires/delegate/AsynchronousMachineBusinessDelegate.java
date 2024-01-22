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
 * AsynchronousMachine business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AsynchronousMachine related services in the case of a
 *       AsynchronousMachine business related service failing.
 *   <li>Exposes a simpler, uniform AsynchronousMachine interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AsynchronousMachine
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AsynchronousMachineBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AsynchronousMachineBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AsynchronousMachine Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AsynchronousMachineBusinessDelegate
   */
  public static AsynchronousMachineBusinessDelegate getAsynchronousMachineInstance() {
    return (new AsynchronousMachineBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAsynchronousMachine(CreateAsynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAsynchronousMachineId() == null)
        command.setAsynchronousMachineId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAsynchronousMachineCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAsynchronousMachineCommand of AsynchronousMachine is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AsynchronousMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAsynchronousMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAsynchronousMachine(UpdateAsynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAsynchronousMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AsynchronousMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAsynchronousMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAsynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAsynchronousMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AsynchronousMachine using Id = " + command.getAsynchronousMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AsynchronousMachine via AsynchronousMachineFetchOneSummary
   *
   * @param summary AsynchronousMachineFetchOneSummary
   * @return AsynchronousMachineFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AsynchronousMachine getAsynchronousMachine(AsynchronousMachineFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AsynchronousMachineFetchOneSummary arg cannot be null");

    AsynchronousMachine entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AsynchronousMachine
      // --------------------------------------
      CompletableFuture<AsynchronousMachine> futureEntity =
          queryGateway.query(
              new FindAsynchronousMachineQuery(
                  new LoadAsynchronousMachineFilter(summary.getAsynchronousMachineId())),
              ResponseTypes.instanceOf(AsynchronousMachine.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AsynchronousMachine with id " + summary.getAsynchronousMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachines
   *
   * @return List<AsynchronousMachine>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AsynchronousMachine> getAllAsynchronousMachine() throws ProcessingException {
    List<AsynchronousMachine> list = null;

    try {
      CompletableFuture<List<AsynchronousMachine>> futureList =
          queryGateway.query(
              new FindAllAsynchronousMachineQuery(),
              ResponseTypes.multipleInstancesOf(AsynchronousMachine.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AsynchronousMachine";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign ConverterFedDrive on AsynchronousMachine
   *
   * @param command AssignConverterFedDriveToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignConverterFedDrive(AssignConverterFedDriveToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign ConverterFedDrive on AsynchronousMachine
   *
   * @param command UnAssignConverterFedDriveFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignConverterFedDrive(
      UnAssignConverterFedDriveFromAsynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ConverterFedDrive on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efficiency on AsynchronousMachine
   *
   * @param command AssignEfficiencyToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignEfficiency(AssignEfficiencyToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign Efficiency on AsynchronousMachine
   *
   * @param command UnAssignEfficiencyFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignEfficiency(UnAssignEfficiencyFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efficiency on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign IaIrRatio on AsynchronousMachine
   *
   * @param command AssignIaIrRatioToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignIaIrRatio(AssignIaIrRatioToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign IaIrRatio on AsynchronousMachine
   *
   * @param command UnAssignIaIrRatioFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignIaIrRatio(UnAssignIaIrRatioFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign IaIrRatio on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NominalFrequency on AsynchronousMachine
   *
   * @param command AssignNominalFrequencyToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignNominalFrequency(AssignNominalFrequencyToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FrequencyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FrequencyBusinessDelegate.getFrequencyInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getFrequencyId();
    Frequency child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Frequency using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NominalFrequency on AsynchronousMachine
   *
   * @param command UnAssignNominalFrequencyFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignNominalFrequency(
      UnAssignNominalFrequencyFromAsynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NominalFrequency on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NominalSpeed on AsynchronousMachine
   *
   * @param command AssignNominalSpeedToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignNominalSpeed(AssignNominalSpeedToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .RotationSpeedBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .RotationSpeedBusinessDelegate.getRotationSpeedInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getRotationSpeedId();
    RotationSpeed child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get RotationSpeed using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NominalSpeed on AsynchronousMachine
   *
   * @param command UnAssignNominalSpeedFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignNominalSpeed(UnAssignNominalSpeedFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NominalSpeed on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PolePairNumber on AsynchronousMachine
   *
   * @param command AssignPolePairNumberToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignPolePairNumber(AssignPolePairNumberToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign PolePairNumber on AsynchronousMachine
   *
   * @param command UnAssignPolePairNumberFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignPolePairNumber(UnAssignPolePairNumberFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PolePairNumber on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedMechanicalPower on AsynchronousMachine
   *
   * @param command AssignRatedMechanicalPowerToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignRatedMechanicalPower(
      AssignRatedMechanicalPowerToAsynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign RatedMechanicalPower on AsynchronousMachine
   *
   * @param command UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignRatedMechanicalPower(
      UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedMechanicalPower on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Reversible on AsynchronousMachine
   *
   * @param command AssignReversibleToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignReversible(AssignReversibleToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign Reversible on AsynchronousMachine
   *
   * @param command UnAssignReversibleFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignReversible(UnAssignReversibleFromAsynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Reversible on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RxLockedRotorRatio on AsynchronousMachine
   *
   * @param command AssignRxLockedRotorRatioToAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignRxLockedRotorRatio(AssignRxLockedRotorRatioToAsynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    AsynchronousMachineBusinessDelegate parentDelegate =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign RxLockedRotorRatio on AsynchronousMachine
   *
   * @param command UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignRxLockedRotorRatio(
      UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RxLockedRotorRatio on AsynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return AsynchronousMachine
   */
  private AsynchronousMachine load(UUID id) throws ProcessingException {
    asynchronousMachine =
        AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
            .getAsynchronousMachine(new AsynchronousMachineFetchOneSummary(id));
    return asynchronousMachine;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AsynchronousMachine asynchronousMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineBusinessDelegate.class.getName());
}
