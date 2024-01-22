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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * ACDCConverter business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ACDCConverter related services in the case of a ACDCConverter
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ACDCConverter interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ACDCConverter business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ACDCConverterBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ACDCConverterBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ACDCConverter Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ACDCConverterBusinessDelegate
   */
  public static ACDCConverterBusinessDelegate getACDCConverterInstance() {
    return (new ACDCConverterBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createACDCConverter(CreateACDCConverterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getACDCConverterId() == null) command.setACDCConverterId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateACDCConverterCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateACDCConverterCommand of ACDCConverter is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ACDCConverter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateACDCConverterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateACDCConverter(UpdateACDCConverterCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateACDCConverterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ACDCConverter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteACDCConverterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteACDCConverterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteACDCConverterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ACDCConverter using Id = " + command.getACDCConverterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ACDCConverter via ACDCConverterFetchOneSummary
   *
   * @param summary ACDCConverterFetchOneSummary
   * @return ACDCConverterFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ACDCConverter getACDCConverter(ACDCConverterFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ACDCConverterFetchOneSummary arg cannot be null");

    ACDCConverter entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ACDCConverter
      // --------------------------------------
      CompletableFuture<ACDCConverter> futureEntity =
          queryGateway.query(
              new FindACDCConverterQuery(new LoadACDCConverterFilter(summary.getACDCConverterId())),
              ResponseTypes.instanceOf(ACDCConverter.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ACDCConverter with id " + summary.getACDCConverterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ACDCConverters
   *
   * @return List<ACDCConverter>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ACDCConverter> getAllACDCConverter() throws ProcessingException {
    List<ACDCConverter> list = null;

    try {
      CompletableFuture<List<ACDCConverter>> futureList =
          queryGateway.query(
              new FindAllACDCConverterQuery(),
              ResponseTypes.multipleInstancesOf(ACDCConverter.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ACDCConverter";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseS on ACDCConverter
   *
   * @param command AssignBaseSToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignBaseS(AssignBaseSToACDCConverterCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ApparentPowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ApparentPowerBusinessDelegate.getApparentPowerInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getApparentPowerId();
    ApparentPower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign BaseS on ACDCConverter
   *
   * @param command UnAssignBaseSFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignBaseS(UnAssignBaseSFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseS on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign IdleLoss on ACDCConverter
   *
   * @param command AssignIdleLossToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignIdleLoss(AssignIdleLossToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign IdleLoss on ACDCConverter
   *
   * @param command UnAssignIdleLossFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignIdleLoss(UnAssignIdleLossFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign IdleLoss on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxUdc on ACDCConverter
   *
   * @param command AssignMaxUdcToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignMaxUdc(AssignMaxUdcToACDCConverterCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign MaxUdc on ACDCConverter
   *
   * @param command UnAssignMaxUdcFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMaxUdc(UnAssignMaxUdcFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxUdc on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinUdc on ACDCConverter
   *
   * @param command AssignMinUdcToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignMinUdc(AssignMinUdcToACDCConverterCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign MinUdc on ACDCConverter
   *
   * @param command UnAssignMinUdcFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignMinUdc(UnAssignMinUdcFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinUdc on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NumberOfValves on ACDCConverter
   *
   * @param command AssignNumberOfValvesToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignNumberOfValves(AssignNumberOfValvesToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign NumberOfValves on ACDCConverter
   *
   * @param command UnAssignNumberOfValvesFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignNumberOfValves(UnAssignNumberOfValvesFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NumberOfValves on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedUdc on ACDCConverter
   *
   * @param command AssignRatedUdcToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignRatedUdc(AssignRatedUdcToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign RatedUdc on ACDCConverter
   *
   * @param command UnAssignRatedUdcFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignRatedUdc(UnAssignRatedUdcFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedUdc on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ResistiveLoss on ACDCConverter
   *
   * @param command AssignResistiveLossToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignResistiveLoss(AssignResistiveLossToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ResistiveLoss on ACDCConverter
   *
   * @param command UnAssignResistiveLossFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignResistiveLoss(UnAssignResistiveLossFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ResistiveLoss on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SwitchingLoss on ACDCConverter
   *
   * @param command AssignSwitchingLossToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignSwitchingLoss(AssignSwitchingLossToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerPerCurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getActivePowerPerCurrentFlowId();
    ActivePowerPerCurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePowerPerCurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SwitchingLoss on ACDCConverter
   *
   * @param command UnAssignSwitchingLossFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignSwitchingLoss(UnAssignSwitchingLossFromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SwitchingLoss on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ValveU0 on ACDCConverter
   *
   * @param command AssignValveU0ToACDCConverterCommand
   * @exception ProcessingException
   */
  public void assignValveU0(AssignValveU0ToACDCConverterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * unAssign ValveU0 on ACDCConverter
   *
   * @param command UnAssignValveU0FromACDCConverterCommand
   * @exception ProcessingException
   */
  public void unAssignValveU0(UnAssignValveU0FromACDCConverterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ValveU0 on ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add ACDCConverter to ConverterDCSides
   *
   * @param command AssignConverterDCSidesToACDCConverterCommand
   * @exception ProcessingException
   */
  public void addToConverterDCSides(AssignConverterDCSidesToACDCConverterCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getACDCConverterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .ACDCConverterBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.ACDCConverterBusinessDelegate.getACDCConverterInstance();
    ACDCConverterBusinessDelegate parentDelegate =
        ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getAddTo().getACDCConverterId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a ACDCConverter as ConverterDCSides to ACDCConverter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ACDCConverter from ConverterDCSides
   *
   * @param command RemoveConverterDCSidesFromACDCConverterCommand
   * @exception ProcessingException
   */
  public void removeFromConverterDCSides(RemoveConverterDCSidesFromACDCConverterCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .ACDCConverterBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.ACDCConverterBusinessDelegate.getACDCConverterInstance();
    UUID childId = command.getRemoveFrom().getACDCConverterId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterValidator.getInstance().validate(command);

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
   * @return ACDCConverter
   */
  private ACDCConverter load(UUID id) throws ProcessingException {
    aCDCConverter =
        ACDCConverterBusinessDelegate.getACDCConverterInstance()
            .getACDCConverter(new ACDCConverterFetchOneSummary(id));
    return aCDCConverter;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ACDCConverter aCDCConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterBusinessDelegate.class.getName());
}
