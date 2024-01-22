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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.validator.*;
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
 * PFVArType2IEEEPFController business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PFVArType2IEEEPFController related services in the case of a
 *       PFVArType2IEEEPFController business related service failing.
 *   <li>Exposes a simpler, uniform PFVArType2IEEEPFController interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PFVArType2IEEEPFController
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PFVArType2IEEEPFControllerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PFVArType2IEEEPFControllerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PFVArType2IEEEPFController Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PFVArType2IEEEPFControllerBusinessDelegate
   */
  public static PFVArType2IEEEPFControllerBusinessDelegate getPFVArType2IEEEPFControllerInstance() {
    return (new PFVArType2IEEEPFControllerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPFVArType2IEEEPFController(
      CreatePFVArType2IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPFVArType2IEEEPFControllerId() == null)
        command.setPFVArType2IEEEPFControllerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePFVArType2IEEEPFControllerCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePFVArType2IEEEPFControllerCommand of PFVArType2IEEEPFController is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PFVArType2IEEEPFController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePFVArType2IEEEPFControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePFVArType2IEEEPFController(
      UpdatePFVArType2IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePFVArType2IEEEPFControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PFVArType2IEEEPFController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePFVArType2IEEEPFControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePFVArType2IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePFVArType2IEEEPFControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PFVArType2IEEEPFController using Id = "
              + command.getPFVArType2IEEEPFControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PFVArType2IEEEPFController via PFVArType2IEEEPFControllerFetchOneSummary
   *
   * @param summary PFVArType2IEEEPFControllerFetchOneSummary
   * @return PFVArType2IEEEPFControllerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PFVArType2IEEEPFController getPFVArType2IEEEPFController(
      PFVArType2IEEEPFControllerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PFVArType2IEEEPFControllerFetchOneSummary arg cannot be null");

    PFVArType2IEEEPFController entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PFVArType2IEEEPFController
      // --------------------------------------
      CompletableFuture<PFVArType2IEEEPFController> futureEntity =
          queryGateway.query(
              new FindPFVArType2IEEEPFControllerQuery(
                  new LoadPFVArType2IEEEPFControllerFilter(
                      summary.getPFVArType2IEEEPFControllerId())),
              ResponseTypes.instanceOf(PFVArType2IEEEPFController.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PFVArType2IEEEPFController with id "
              + summary.getPFVArType2IEEEPFControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PFVArType2IEEEPFControllers
   *
   * @return List<PFVArType2IEEEPFController>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PFVArType2IEEEPFController> getAllPFVArType2IEEEPFController()
      throws ProcessingException {
    List<PFVArType2IEEEPFController> list = null;

    try {
      CompletableFuture<List<PFVArType2IEEEPFController>> futureList =
          queryGateway.query(
              new FindAllPFVArType2IEEEPFControllerQuery(),
              ResponseTypes.multipleInstancesOf(PFVArType2IEEEPFController.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Exlon on PFVArType2IEEEPFController
   *
   * @param command AssignExlonToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignExlon(AssignExlonToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Exlon on PFVArType2IEEEPFController
   *
   * @param command UnAssignExlonFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignExlon(UnAssignExlonFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Exlon on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ki on PFVArType2IEEEPFController
   *
   * @param command AssignKiToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignKi(AssignKiToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Ki on PFVArType2IEEEPFController
   *
   * @param command UnAssignKiFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignKi(UnAssignKiFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ki on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kp on PFVArType2IEEEPFController
   *
   * @param command AssignKpToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignKp(AssignKpToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Kp on PFVArType2IEEEPFController
   *
   * @param command UnAssignKpFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignKp(UnAssignKpFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kp on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pfref on PFVArType2IEEEPFController
   *
   * @param command AssignPfrefToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignPfref(AssignPfrefToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Pfref on PFVArType2IEEEPFController
   *
   * @param command UnAssignPfrefFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignPfref(UnAssignPfrefFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pfref on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vclmt on PFVArType2IEEEPFController
   *
   * @param command AssignVclmtToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVclmt(AssignVclmtToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vclmt on PFVArType2IEEEPFController
   *
   * @param command UnAssignVclmtFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVclmt(UnAssignVclmtFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vclmt on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vref on PFVArType2IEEEPFController
   *
   * @param command AssignVrefToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVref(AssignVrefToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vref on PFVArType2IEEEPFController
   *
   * @param command UnAssignVrefFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVref(UnAssignVrefFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vref on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vs on PFVArType2IEEEPFController
   *
   * @param command AssignVsToPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVs(AssignVsToPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType2IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PFVArType2IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vs on PFVArType2IEEEPFController
   *
   * @param command UnAssignVsFromPFVArType2IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVs(UnAssignVsFromPFVArType2IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType2IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vs on PFVArType2IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PFVArType2IEEEPFController
   */
  private PFVArType2IEEEPFController load(UUID id) throws ProcessingException {
    pFVArType2IEEEPFController =
        PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
            .getPFVArType2IEEEPFController(new PFVArType2IEEEPFControllerFetchOneSummary(id));
    return pFVArType2IEEEPFController;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PFVArType2IEEEPFController pFVArType2IEEEPFController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEPFControllerBusinessDelegate.class.getName());
}
