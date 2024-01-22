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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.validator.*;
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
 * PFVArType1IEEEPFController business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PFVArType1IEEEPFController related services in the case of a
 *       PFVArType1IEEEPFController business related service failing.
 *   <li>Exposes a simpler, uniform PFVArType1IEEEPFController interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PFVArType1IEEEPFController
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PFVArType1IEEEPFControllerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PFVArType1IEEEPFControllerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PFVArType1IEEEPFController Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PFVArType1IEEEPFControllerBusinessDelegate
   */
  public static PFVArType1IEEEPFControllerBusinessDelegate getPFVArType1IEEEPFControllerInstance() {
    return (new PFVArType1IEEEPFControllerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPFVArType1IEEEPFController(
      CreatePFVArType1IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPFVArType1IEEEPFControllerId() == null)
        command.setPFVArType1IEEEPFControllerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePFVArType1IEEEPFControllerCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePFVArType1IEEEPFControllerCommand of PFVArType1IEEEPFController is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PFVArType1IEEEPFController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePFVArType1IEEEPFControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePFVArType1IEEEPFController(
      UpdatePFVArType1IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePFVArType1IEEEPFControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PFVArType1IEEEPFController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePFVArType1IEEEPFControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePFVArType1IEEEPFControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePFVArType1IEEEPFControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PFVArType1IEEEPFController using Id = "
              + command.getPFVArType1IEEEPFControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PFVArType1IEEEPFController via PFVArType1IEEEPFControllerFetchOneSummary
   *
   * @param summary PFVArType1IEEEPFControllerFetchOneSummary
   * @return PFVArType1IEEEPFControllerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PFVArType1IEEEPFController getPFVArType1IEEEPFController(
      PFVArType1IEEEPFControllerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PFVArType1IEEEPFControllerFetchOneSummary arg cannot be null");

    PFVArType1IEEEPFController entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PFVArType1IEEEPFController
      // --------------------------------------
      CompletableFuture<PFVArType1IEEEPFController> futureEntity =
          queryGateway.query(
              new FindPFVArType1IEEEPFControllerQuery(
                  new LoadPFVArType1IEEEPFControllerFilter(
                      summary.getPFVArType1IEEEPFControllerId())),
              ResponseTypes.instanceOf(PFVArType1IEEEPFController.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PFVArType1IEEEPFController with id "
              + summary.getPFVArType1IEEEPFControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEPFControllers
   *
   * @return List<PFVArType1IEEEPFController>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PFVArType1IEEEPFController> getAllPFVArType1IEEEPFController()
      throws ProcessingException {
    List<PFVArType1IEEEPFController> list = null;

    try {
      CompletableFuture<List<PFVArType1IEEEPFController>> futureList =
          queryGateway.query(
              new FindAllPFVArType1IEEEPFControllerQuery(),
              ResponseTypes.multipleInstancesOf(PFVArType1IEEEPFController.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Ovex on PFVArType1IEEEPFController
   *
   * @param command AssignOvexToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignOvex(AssignOvexToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Ovex on PFVArType1IEEEPFController
   *
   * @param command UnAssignOvexFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignOvex(UnAssignOvexFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ovex on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpfc on PFVArType1IEEEPFController
   *
   * @param command AssignTpfcToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignTpfc(AssignTpfcToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Tpfc on PFVArType1IEEEPFController
   *
   * @param command UnAssignTpfcFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignTpfc(UnAssignTpfcFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpfc on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vitmin on PFVArType1IEEEPFController
   *
   * @param command AssignVitminToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVitmin(AssignVitminToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vitmin on PFVArType1IEEEPFController
   *
   * @param command UnAssignVitminFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVitmin(UnAssignVitminFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vitmin on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vpf on PFVArType1IEEEPFController
   *
   * @param command AssignVpfToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVpf(AssignVpfToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vpf on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVpf(UnAssignVpfFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vpf on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vpfcbw on PFVArType1IEEEPFController
   *
   * @param command AssignVpfcbwToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVpfcbw(AssignVpfcbwToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vpfcbw on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVpfcbw(UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vpfcbw on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vpfref on PFVArType1IEEEPFController
   *
   * @param command AssignVpfrefToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVpfref(AssignVpfrefToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vpfref on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVpfref(UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vpfref on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvtmax on PFVArType1IEEEPFController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVvtmax(AssignVvtmaxToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vvtmax on PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvtmax(UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvtmax on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvtmin on PFVArType1IEEEPFController
   *
   * @param command AssignVvtminToPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void assignVvtmin(AssignVvtminToPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEPFControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEPFControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

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
   * unAssign Vvtmin on PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEPFControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvtmin(UnAssignVvtminFromPFVArType1IEEEPFControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEPFControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvtmin on PFVArType1IEEEPFController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PFVArType1IEEEPFController
   */
  private PFVArType1IEEEPFController load(UUID id) throws ProcessingException {
    pFVArType1IEEEPFController =
        PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
            .getPFVArType1IEEEPFController(new PFVArType1IEEEPFControllerFetchOneSummary(id));
    return pFVArType1IEEEPFController;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PFVArType1IEEEPFController pFVArType1IEEEPFController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEPFControllerBusinessDelegate.class.getName());
}
