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
 * PFVArType1IEEEVArController business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PFVArType1IEEEVArController related services in the case of a
 *       PFVArType1IEEEVArController business related service failing.
 *   <li>Exposes a simpler, uniform PFVArType1IEEEVArController interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       PFVArType1IEEEVArController business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PFVArType1IEEEVArControllerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PFVArType1IEEEVArControllerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PFVArType1IEEEVArController Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PFVArType1IEEEVArControllerBusinessDelegate
   */
  public static PFVArType1IEEEVArControllerBusinessDelegate
      getPFVArType1IEEEVArControllerInstance() {
    return (new PFVArType1IEEEVArControllerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPFVArType1IEEEVArController(
      CreatePFVArType1IEEEVArControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPFVArType1IEEEVArControllerId() == null)
        command.setPFVArType1IEEEVArControllerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePFVArType1IEEEVArControllerCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePFVArType1IEEEVArControllerCommand of PFVArType1IEEEVArController is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PFVArType1IEEEVArController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePFVArType1IEEEVArControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePFVArType1IEEEVArController(
      UpdatePFVArType1IEEEVArControllerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePFVArType1IEEEVArControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PFVArType1IEEEVArController - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePFVArType1IEEEVArControllerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePFVArType1IEEEVArControllerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePFVArType1IEEEVArControllerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PFVArType1IEEEVArController using Id = "
              + command.getPFVArType1IEEEVArControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PFVArType1IEEEVArController via
   * PFVArType1IEEEVArControllerFetchOneSummary
   *
   * @param summary PFVArType1IEEEVArControllerFetchOneSummary
   * @return PFVArType1IEEEVArControllerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PFVArType1IEEEVArController getPFVArType1IEEEVArController(
      PFVArType1IEEEVArControllerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PFVArType1IEEEVArControllerFetchOneSummary arg cannot be null");

    PFVArType1IEEEVArController entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PFVArType1IEEEVArController
      // --------------------------------------
      CompletableFuture<PFVArType1IEEEVArController> futureEntity =
          queryGateway.query(
              new FindPFVArType1IEEEVArControllerQuery(
                  new LoadPFVArType1IEEEVArControllerFilter(
                      summary.getPFVArType1IEEEVArControllerId())),
              ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PFVArType1IEEEVArController with id "
              + summary.getPFVArType1IEEEVArControllerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEVArControllers
   *
   * @return List<PFVArType1IEEEVArController>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PFVArType1IEEEVArController> getAllPFVArType1IEEEVArController()
      throws ProcessingException {
    List<PFVArType1IEEEVArController> list = null;

    try {
      CompletableFuture<List<PFVArType1IEEEVArController>> futureList =
          queryGateway.query(
              new FindAllPFVArType1IEEEVArControllerQuery(),
              ResponseTypes.multipleInstancesOf(PFVArType1IEEEVArController.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Tvarc on PFVArType1IEEEVArController
   *
   * @param command AssignTvarcToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignTvarc(AssignTvarcToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Tvarc on PFVArType1IEEEVArController
   *
   * @param command UnAssignTvarcFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignTvarc(UnAssignTvarcFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tvarc on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvar on PFVArType1IEEEVArController
   *
   * @param command AssignVvarToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignVvar(AssignVvarToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Vvar on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvar(UnAssignVvarFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvar on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvarcbw on PFVArType1IEEEVArController
   *
   * @param command AssignVvarcbwToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignVvarcbw(AssignVvarcbwToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Vvarcbw on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvarcbw(UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvarcbw on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvarref on PFVArType1IEEEVArController
   *
   * @param command AssignVvarrefToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignVvarref(AssignVvarrefToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Vvarref on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvarref(UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvarref on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvtmax on PFVArType1IEEEVArController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignVvtmax(AssignVvtmaxToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Vvtmax on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvtmax(UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvtmax on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vvtmin on PFVArType1IEEEVArController
   *
   * @param command AssignVvtminToPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void assignVvtmin(AssignVvtminToPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArType1IEEEVArControllerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PFVArType1IEEEVArControllerBusinessDelegate parentDelegate =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

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
   * unAssign Vvtmin on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEVArControllerCommand
   * @exception ProcessingException
   */
  public void unAssignVvtmin(UnAssignVvtminFromPFVArType1IEEEVArControllerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArType1IEEEVArControllerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vvtmin on PFVArType1IEEEVArController";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PFVArType1IEEEVArController
   */
  private PFVArType1IEEEVArController load(UUID id) throws ProcessingException {
    pFVArType1IEEEVArController =
        PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
            .getPFVArType1IEEEVArController(new PFVArType1IEEEVArControllerFetchOneSummary(id));
    return pFVArType1IEEEVArController;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PFVArType1IEEEVArController pFVArType1IEEEVArController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEVArControllerBusinessDelegate.class.getName());
}
