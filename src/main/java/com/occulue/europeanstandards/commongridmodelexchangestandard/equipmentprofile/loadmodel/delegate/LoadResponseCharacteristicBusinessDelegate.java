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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator.*;
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
 * LoadResponseCharacteristic business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of LoadResponseCharacteristic related services in the case of a
 *       LoadResponseCharacteristic business related service failing.
 *   <li>Exposes a simpler, uniform LoadResponseCharacteristic interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill LoadResponseCharacteristic
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LoadResponseCharacteristicBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LoadResponseCharacteristicBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * LoadResponseCharacteristic Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LoadResponseCharacteristicBusinessDelegate
   */
  public static LoadResponseCharacteristicBusinessDelegate getLoadResponseCharacteristicInstance() {
    return (new LoadResponseCharacteristicBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLoadResponseCharacteristic(
      CreateLoadResponseCharacteristicCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLoadResponseCharacteristicId() == null)
        command.setLoadResponseCharacteristicId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLoadResponseCharacteristicCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLoadResponseCharacteristicCommand of LoadResponseCharacteristic is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create LoadResponseCharacteristic - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLoadResponseCharacteristicCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLoadResponseCharacteristic(
      UpdateLoadResponseCharacteristicCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLoadResponseCharacteristicCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save LoadResponseCharacteristic - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLoadResponseCharacteristicCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLoadResponseCharacteristicCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLoadResponseCharacteristicCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete LoadResponseCharacteristic using Id = "
              + command.getLoadResponseCharacteristicId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the LoadResponseCharacteristic via LoadResponseCharacteristicFetchOneSummary
   *
   * @param summary LoadResponseCharacteristicFetchOneSummary
   * @return LoadResponseCharacteristicFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public LoadResponseCharacteristic getLoadResponseCharacteristic(
      LoadResponseCharacteristicFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "LoadResponseCharacteristicFetchOneSummary arg cannot be null");

    LoadResponseCharacteristic entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a LoadResponseCharacteristic
      // --------------------------------------
      CompletableFuture<LoadResponseCharacteristic> futureEntity =
          queryGateway.query(
              new FindLoadResponseCharacteristicQuery(
                  new LoadLoadResponseCharacteristicFilter(
                      summary.getLoadResponseCharacteristicId())),
              ResponseTypes.instanceOf(LoadResponseCharacteristic.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate LoadResponseCharacteristic with id "
              + summary.getLoadResponseCharacteristicId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all LoadResponseCharacteristics
   *
   * @return List<LoadResponseCharacteristic>
   * @exception ProcessingException Thrown if any problems
   */
  public List<LoadResponseCharacteristic> getAllLoadResponseCharacteristic()
      throws ProcessingException {
    List<LoadResponseCharacteristic> list = null;

    try {
      CompletableFuture<List<LoadResponseCharacteristic>> futureList =
          queryGateway.query(
              new FindAllLoadResponseCharacteristicQuery(),
              ResponseTypes.multipleInstancesOf(LoadResponseCharacteristic.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign ExponentModel on LoadResponseCharacteristic
   *
   * @param command AssignExponentModelToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignExponentModel(AssignExponentModelToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign ExponentModel on LoadResponseCharacteristic
   *
   * @param command UnAssignExponentModelFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignExponentModel(
      UnAssignExponentModelFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ExponentModel on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PConstantCurrent on LoadResponseCharacteristic
   *
   * @param command AssignPConstantCurrentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignPConstantCurrent(
      AssignPConstantCurrentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign PConstantCurrent on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignPConstantCurrent(
      UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PConstantCurrent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PConstantImpedance on LoadResponseCharacteristic
   *
   * @param command AssignPConstantImpedanceToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignPConstantImpedance(
      AssignPConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign PConstantImpedance on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignPConstantImpedance(
      UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PConstantImpedance on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PConstantPower on LoadResponseCharacteristic
   *
   * @param command AssignPConstantPowerToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignPConstantPower(AssignPConstantPowerToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign PConstantPower on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantPowerFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignPConstantPower(
      UnAssignPConstantPowerFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PConstantPower on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command AssignPFrequencyExponentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignPFrequencyExponent(
      AssignPFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign PFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignPFrequencyExponent(
      UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PFrequencyExponent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PVoltageExponent on LoadResponseCharacteristic
   *
   * @param command AssignPVoltageExponentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignPVoltageExponent(
      AssignPVoltageExponentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign PVoltageExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignPVoltageExponent(
      UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PVoltageExponent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QConstantCurrent on LoadResponseCharacteristic
   *
   * @param command AssignQConstantCurrentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignQConstantCurrent(
      AssignQConstantCurrentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign QConstantCurrent on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignQConstantCurrent(
      UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QConstantCurrent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QConstantImpedance on LoadResponseCharacteristic
   *
   * @param command AssignQConstantImpedanceToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignQConstantImpedance(
      AssignQConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign QConstantImpedance on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignQConstantImpedance(
      UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QConstantImpedance on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QConstantPower on LoadResponseCharacteristic
   *
   * @param command AssignQConstantPowerToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignQConstantPower(AssignQConstantPowerToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign QConstantPower on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantPowerFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignQConstantPower(
      UnAssignQConstantPowerFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QConstantPower on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command AssignQFrequencyExponentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignQFrequencyExponent(
      AssignQFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign QFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignQFrequencyExponent(
      UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QFrequencyExponent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QVoltageExponent on LoadResponseCharacteristic
   *
   * @param command AssignQVoltageExponentToLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void assignQVoltageExponent(
      AssignQVoltageExponentToLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadResponseCharacteristicId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadResponseCharacteristicBusinessDelegate parentDelegate =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

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
   * unAssign QVoltageExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand
   * @exception ProcessingException
   */
  public void unAssignQVoltageExponent(
      UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadResponseCharacteristicValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QVoltageExponent on LoadResponseCharacteristic";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return LoadResponseCharacteristic
   */
  private LoadResponseCharacteristic load(UUID id) throws ProcessingException {
    loadResponseCharacteristic =
        LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
            .getLoadResponseCharacteristic(new LoadResponseCharacteristicFetchOneSummary(id));
    return loadResponseCharacteristic;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private LoadResponseCharacteristic loadResponseCharacteristic = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicBusinessDelegate.class.getName());
}
