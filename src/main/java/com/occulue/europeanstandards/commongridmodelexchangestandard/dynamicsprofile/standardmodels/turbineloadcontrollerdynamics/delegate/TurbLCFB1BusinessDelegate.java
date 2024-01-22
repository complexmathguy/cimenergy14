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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.validator.*;
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
 * TurbLCFB1 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TurbLCFB1 related services in the case of a TurbLCFB1 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform TurbLCFB1 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TurbLCFB1 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TurbLCFB1BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TurbLCFB1BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TurbLCFB1 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TurbLCFB1BusinessDelegate
   */
  public static TurbLCFB1BusinessDelegate getTurbLCFB1Instance() {
    return (new TurbLCFB1BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTurbLCFB1(CreateTurbLCFB1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTurbLCFB1Id() == null) command.setTurbLCFB1Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTurbLCFB1Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTurbLCFB1Command of TurbLCFB1 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TurbLCFB1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTurbLCFB1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTurbLCFB1(UpdateTurbLCFB1Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTurbLCFB1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TurbLCFB1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTurbLCFB1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTurbLCFB1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTurbLCFB1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete TurbLCFB1 using Id = " + command.getTurbLCFB1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TurbLCFB1 via TurbLCFB1FetchOneSummary
   *
   * @param summary TurbLCFB1FetchOneSummary
   * @return TurbLCFB1FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TurbLCFB1 getTurbLCFB1(TurbLCFB1FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TurbLCFB1FetchOneSummary arg cannot be null");

    TurbLCFB1 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TurbLCFB1
      // --------------------------------------
      CompletableFuture<TurbLCFB1> futureEntity =
          queryGateway.query(
              new FindTurbLCFB1Query(new LoadTurbLCFB1Filter(summary.getTurbLCFB1Id())),
              ResponseTypes.instanceOf(TurbLCFB1.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate TurbLCFB1 with id " + summary.getTurbLCFB1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TurbLCFB1s
   *
   * @return List<TurbLCFB1>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TurbLCFB1> getAllTurbLCFB1() throws ProcessingException {
    List<TurbLCFB1> list = null;

    try {
      CompletableFuture<List<TurbLCFB1>> futureList =
          queryGateway.query(
              new FindAllTurbLCFB1Query(), ResponseTypes.multipleInstancesOf(TurbLCFB1.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TurbLCFB1";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Db on TurbLCFB1
   *
   * @param command AssignDbToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignDb(AssignDbToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Db on TurbLCFB1
   *
   * @param command UnAssignDbFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignDb(UnAssignDbFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Db on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Emax on TurbLCFB1
   *
   * @param command AssignEmaxToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignEmax(AssignEmaxToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Emax on TurbLCFB1
   *
   * @param command UnAssignEmaxFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignEmax(UnAssignEmaxFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Emax on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Fb on TurbLCFB1
   *
   * @param command AssignFbToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignFb(AssignFbToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Fb on TurbLCFB1
   *
   * @param command UnAssignFbFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignFb(UnAssignFbFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Fb on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Fbf on TurbLCFB1
   *
   * @param command AssignFbfToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignFbf(AssignFbfToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign Fbf on TurbLCFB1
   *
   * @param command UnAssignFbfFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignFbf(UnAssignFbfFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Fbf on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Irmax on TurbLCFB1
   *
   * @param command AssignIrmaxToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignIrmax(AssignIrmaxToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Irmax on TurbLCFB1
   *
   * @param command UnAssignIrmaxFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignIrmax(UnAssignIrmaxFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Irmax on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ki on TurbLCFB1
   *
   * @param command AssignKiToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignKi(AssignKiToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ki on TurbLCFB1
   *
   * @param command UnAssignKiFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignKi(UnAssignKiFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ki on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kp on TurbLCFB1
   *
   * @param command AssignKpToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignKp(AssignKpToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kp on TurbLCFB1
   *
   * @param command UnAssignKpFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignKp(UnAssignKpFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kp on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwbase on TurbLCFB1
   *
   * @param command AssignMwbaseToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignMwbase(AssignMwbaseToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign Mwbase on TurbLCFB1
   *
   * @param command UnAssignMwbaseFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignMwbase(UnAssignMwbaseFromTurbLCFB1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwbase on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pbf on TurbLCFB1
   *
   * @param command AssignPbfToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignPbf(AssignPbfToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign Pbf on TurbLCFB1
   *
   * @param command UnAssignPbfFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignPbf(UnAssignPbfFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pbf on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmwset on TurbLCFB1
   *
   * @param command AssignPmwsetToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignPmwset(AssignPmwsetToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign Pmwset on TurbLCFB1
   *
   * @param command UnAssignPmwsetFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignPmwset(UnAssignPmwsetFromTurbLCFB1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmwset on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SpeedReferenceGovernor on TurbLCFB1
   *
   * @param command AssignSpeedReferenceGovernorToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignSpeedReferenceGovernor(AssignSpeedReferenceGovernorToTurbLCFB1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign SpeedReferenceGovernor on TurbLCFB1
   *
   * @param command UnAssignSpeedReferenceGovernorFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignSpeedReferenceGovernor(
      UnAssignSpeedReferenceGovernorFromTurbLCFB1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SpeedReferenceGovernor on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpelec on TurbLCFB1
   *
   * @param command AssignTpelecToTurbLCFB1Command
   * @exception ProcessingException
   */
  public void assignTpelec(AssignTpelecToTurbLCFB1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbLCFB1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    TurbLCFB1BusinessDelegate parentDelegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

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
   * unAssign Tpelec on TurbLCFB1
   *
   * @param command UnAssignTpelecFromTurbLCFB1Command
   * @exception ProcessingException
   */
  public void unAssignTpelec(UnAssignTpelecFromTurbLCFB1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbLCFB1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpelec on TurbLCFB1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TurbLCFB1
   */
  private TurbLCFB1 load(UUID id) throws ProcessingException {
    turbLCFB1 =
        TurbLCFB1BusinessDelegate.getTurbLCFB1Instance()
            .getTurbLCFB1(new TurbLCFB1FetchOneSummary(id));
    return turbLCFB1;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TurbLCFB1 turbLCFB1 = null;
  private static final Logger LOGGER = Logger.getLogger(TurbLCFB1BusinessDelegate.class.getName());
}
