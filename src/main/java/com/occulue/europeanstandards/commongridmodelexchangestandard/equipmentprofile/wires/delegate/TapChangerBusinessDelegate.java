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
 * TapChanger business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TapChanger related services in the case of a TapChanger business
 *       related service failing.
 *   <li>Exposes a simpler, uniform TapChanger interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TapChanger business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TapChangerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TapChangerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TapChanger Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TapChangerBusinessDelegate
   */
  public static TapChangerBusinessDelegate getTapChangerInstance() {
    return (new TapChangerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTapChanger(CreateTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTapChangerId() == null) command.setTapChangerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTapChangerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTapChangerCommand of TapChanger is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TapChanger - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTapChangerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTapChanger(UpdateTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTapChangerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TapChanger - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTapChangerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTapChangerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete TapChanger using Id = " + command.getTapChangerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TapChanger via TapChangerFetchOneSummary
   *
   * @param summary TapChangerFetchOneSummary
   * @return TapChangerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TapChanger getTapChanger(TapChangerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TapChangerFetchOneSummary arg cannot be null");

    TapChanger entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TapChangerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TapChanger
      // --------------------------------------
      CompletableFuture<TapChanger> futureEntity =
          queryGateway.query(
              new FindTapChangerQuery(new LoadTapChangerFilter(summary.getTapChangerId())),
              ResponseTypes.instanceOf(TapChanger.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate TapChanger with id " + summary.getTapChangerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TapChangers
   *
   * @return List<TapChanger>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TapChanger> getAllTapChanger() throws ProcessingException {
    List<TapChanger> list = null;

    try {
      CompletableFuture<List<TapChanger>> futureList =
          queryGateway.query(
              new FindAllTapChangerQuery(), ResponseTypes.multipleInstancesOf(TapChanger.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TapChanger";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign HighStep on TapChanger
   *
   * @param command AssignHighStepToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignHighStep(AssignHighStepToTapChangerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign HighStep on TapChanger
   *
   * @param command UnAssignHighStepFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignHighStep(UnAssignHighStepFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign HighStep on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign LowStep on TapChanger
   *
   * @param command AssignLowStepToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignLowStep(AssignLowStepToTapChangerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign LowStep on TapChanger
   *
   * @param command UnAssignLowStepFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignLowStep(UnAssignLowStepFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign LowStep on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign LtcFlag on TapChanger
   *
   * @param command AssignLtcFlagToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignLtcFlag(AssignLtcFlagToTapChangerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign LtcFlag on TapChanger
   *
   * @param command UnAssignLtcFlagFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignLtcFlag(UnAssignLtcFlagFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign LtcFlag on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NeutralStep on TapChanger
   *
   * @param command AssignNeutralStepToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignNeutralStep(AssignNeutralStepToTapChangerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign NeutralStep on TapChanger
   *
   * @param command UnAssignNeutralStepFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignNeutralStep(UnAssignNeutralStepFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NeutralStep on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NeutralU on TapChanger
   *
   * @param command AssignNeutralUToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignNeutralU(AssignNeutralUToTapChangerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign NeutralU on TapChanger
   *
   * @param command UnAssignNeutralUFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignNeutralU(UnAssignNeutralUFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NeutralU on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NormalStep on TapChanger
   *
   * @param command AssignNormalStepToTapChangerCommand
   * @exception ProcessingException
   */
  public void assignNormalStep(AssignNormalStepToTapChangerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * unAssign NormalStep on TapChanger
   *
   * @param command UnAssignNormalStepFromTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignNormalStep(UnAssignNormalStepFromTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NormalStep on TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add TapChanger to TapChanger
   *
   * @param command AssignTapChangerToTapChangerCommand
   * @exception ProcessingException
   */
  public void addToTapChanger(AssignTapChangerToTapChangerCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TapChangerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TapChangerBusinessDelegate.getTapChangerInstance();
    TapChangerBusinessDelegate parentDelegate = TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getAddTo().getTapChangerId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TapChanger as TapChanger to TapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TapChanger from TapChanger
   *
   * @param command RemoveTapChangerFromTapChangerCommand
   * @exception ProcessingException
   */
  public void removeFromTapChanger(RemoveTapChangerFromTapChangerCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .TapChangerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.TapChangerBusinessDelegate.getTapChangerInstance();
    UUID childId = command.getRemoveFrom().getTapChangerId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerValidator.getInstance().validate(command);

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
   * @return TapChanger
   */
  private TapChanger load(UUID id) throws ProcessingException {
    tapChanger =
        TapChangerBusinessDelegate.getTapChangerInstance()
            .getTapChanger(new TapChangerFetchOneSummary(id));
    return tapChanger;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TapChanger tapChanger = null;
  private static final Logger LOGGER = Logger.getLogger(TapChangerBusinessDelegate.class.getName());
}
