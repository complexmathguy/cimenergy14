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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.validator.*;
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
 * VAdjIEEE business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VAdjIEEE related services in the case of a VAdjIEEE business
 *       related service failing.
 *   <li>Exposes a simpler, uniform VAdjIEEE interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VAdjIEEE business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VAdjIEEEBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VAdjIEEEBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VAdjIEEE Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VAdjIEEEBusinessDelegate
   */
  public static VAdjIEEEBusinessDelegate getVAdjIEEEInstance() {
    return (new VAdjIEEEBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVAdjIEEE(CreateVAdjIEEECommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVAdjIEEEId() == null) command.setVAdjIEEEId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVAdjIEEECommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVAdjIEEECommand of VAdjIEEE is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VAdjIEEE - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVAdjIEEECommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVAdjIEEE(UpdateVAdjIEEECommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVAdjIEEECommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VAdjIEEE - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVAdjIEEECommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVAdjIEEECommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVAdjIEEECommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete VAdjIEEE using Id = " + command.getVAdjIEEEId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VAdjIEEE via VAdjIEEEFetchOneSummary
   *
   * @param summary VAdjIEEEFetchOneSummary
   * @return VAdjIEEEFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VAdjIEEE getVAdjIEEE(VAdjIEEEFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VAdjIEEEFetchOneSummary arg cannot be null");

    VAdjIEEE entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VAdjIEEE
      // --------------------------------------
      CompletableFuture<VAdjIEEE> futureEntity =
          queryGateway.query(
              new FindVAdjIEEEQuery(new LoadVAdjIEEEFilter(summary.getVAdjIEEEId())),
              ResponseTypes.instanceOf(VAdjIEEE.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate VAdjIEEE with id " + summary.getVAdjIEEEId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VAdjIEEEs
   *
   * @return List<VAdjIEEE>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VAdjIEEE> getAllVAdjIEEE() throws ProcessingException {
    List<VAdjIEEE> list = null;

    try {
      CompletableFuture<List<VAdjIEEE>> futureList =
          queryGateway.query(
              new FindAllVAdjIEEEQuery(), ResponseTypes.multipleInstancesOf(VAdjIEEE.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VAdjIEEE";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Adjslew on VAdjIEEE
   *
   * @param command AssignAdjslewToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignAdjslew(AssignAdjslewToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Adjslew on VAdjIEEE
   *
   * @param command UnAssignAdjslewFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignAdjslew(UnAssignAdjslewFromVAdjIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Adjslew on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Taoff on VAdjIEEE
   *
   * @param command AssignTaoffToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignTaoff(AssignTaoffToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Taoff on VAdjIEEE
   *
   * @param command UnAssignTaoffFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignTaoff(UnAssignTaoffFromVAdjIEEECommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Taoff on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Taon on VAdjIEEE
   *
   * @param command AssignTaonToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignTaon(AssignTaonToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Taon on VAdjIEEE
   *
   * @param command UnAssignTaonFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignTaon(UnAssignTaonFromVAdjIEEECommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Taon on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vadjf on VAdjIEEE
   *
   * @param command AssignVadjfToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignVadjf(AssignVadjfToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Vadjf on VAdjIEEE
   *
   * @param command UnAssignVadjfFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignVadjf(UnAssignVadjfFromVAdjIEEECommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vadjf on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vadjmax on VAdjIEEE
   *
   * @param command AssignVadjmaxToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignVadjmax(AssignVadjmaxToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Vadjmax on VAdjIEEE
   *
   * @param command UnAssignVadjmaxFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignVadjmax(UnAssignVadjmaxFromVAdjIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vadjmax on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vadjmin on VAdjIEEE
   *
   * @param command AssignVadjminToVAdjIEEECommand
   * @exception ProcessingException
   */
  public void assignVadjmin(AssignVadjminToVAdjIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVAdjIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    VAdjIEEEBusinessDelegate parentDelegate = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

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
   * unAssign Vadjmin on VAdjIEEE
   *
   * @param command UnAssignVadjminFromVAdjIEEECommand
   * @exception ProcessingException
   */
  public void unAssignVadjmin(UnAssignVadjminFromVAdjIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VAdjIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vadjmin on VAdjIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VAdjIEEE
   */
  private VAdjIEEE load(UUID id) throws ProcessingException {
    vAdjIEEE =
        VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().getVAdjIEEE(new VAdjIEEEFetchOneSummary(id));
    return vAdjIEEE;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VAdjIEEE vAdjIEEE = null;
  private static final Logger LOGGER = Logger.getLogger(VAdjIEEEBusinessDelegate.class.getName());
}
