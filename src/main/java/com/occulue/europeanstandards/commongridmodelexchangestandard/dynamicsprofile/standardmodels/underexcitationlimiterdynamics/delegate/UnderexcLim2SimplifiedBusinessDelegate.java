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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator.*;
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
 * UnderexcLim2Simplified business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of UnderexcLim2Simplified related services in the case of a
 *       UnderexcLim2Simplified business related service failing.
 *   <li>Exposes a simpler, uniform UnderexcLim2Simplified interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill UnderexcLim2Simplified
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class UnderexcLim2SimplifiedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public UnderexcLim2SimplifiedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * UnderexcLim2Simplified Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return UnderexcLim2SimplifiedBusinessDelegate
   */
  public static UnderexcLim2SimplifiedBusinessDelegate getUnderexcLim2SimplifiedInstance() {
    return (new UnderexcLim2SimplifiedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createUnderexcLim2Simplified(
      CreateUnderexcLim2SimplifiedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getUnderexcLim2SimplifiedId() == null)
        command.setUnderexcLim2SimplifiedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateUnderexcLim2SimplifiedCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateUnderexcLim2SimplifiedCommand of UnderexcLim2Simplified is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create UnderexcLim2Simplified - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateUnderexcLim2SimplifiedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateUnderexcLim2Simplified(
      UpdateUnderexcLim2SimplifiedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateUnderexcLim2SimplifiedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save UnderexcLim2Simplified - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteUnderexcLim2SimplifiedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteUnderexcLim2SimplifiedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteUnderexcLim2SimplifiedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete UnderexcLim2Simplified using Id = "
              + command.getUnderexcLim2SimplifiedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the UnderexcLim2Simplified via UnderexcLim2SimplifiedFetchOneSummary
   *
   * @param summary UnderexcLim2SimplifiedFetchOneSummary
   * @return UnderexcLim2SimplifiedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public UnderexcLim2Simplified getUnderexcLim2Simplified(
      UnderexcLim2SimplifiedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "UnderexcLim2SimplifiedFetchOneSummary arg cannot be null");

    UnderexcLim2Simplified entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a UnderexcLim2Simplified
      // --------------------------------------
      CompletableFuture<UnderexcLim2Simplified> futureEntity =
          queryGateway.query(
              new FindUnderexcLim2SimplifiedQuery(
                  new LoadUnderexcLim2SimplifiedFilter(summary.getUnderexcLim2SimplifiedId())),
              ResponseTypes.instanceOf(UnderexcLim2Simplified.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate UnderexcLim2Simplified with id "
              + summary.getUnderexcLim2SimplifiedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all UnderexcLim2Simplifieds
   *
   * @return List<UnderexcLim2Simplified>
   * @exception ProcessingException Thrown if any problems
   */
  public List<UnderexcLim2Simplified> getAllUnderexcLim2Simplified() throws ProcessingException {
    List<UnderexcLim2Simplified> list = null;

    try {
      CompletableFuture<List<UnderexcLim2Simplified>> futureList =
          queryGateway.query(
              new FindAllUnderexcLim2SimplifiedQuery(),
              ResponseTypes.multipleInstancesOf(UnderexcLim2Simplified.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kui on UnderexcLim2Simplified
   *
   * @param command AssignKuiToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignKui(AssignKuiToUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign Kui on UnderexcLim2Simplified
   *
   * @param command UnAssignKuiFromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignKui(UnAssignKuiFromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kui on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P0 on UnderexcLim2Simplified
   *
   * @param command AssignP0ToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignP0(AssignP0ToUnderexcLim2SimplifiedCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign P0 on UnderexcLim2Simplified
   *
   * @param command UnAssignP0FromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignP0(UnAssignP0FromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P0 on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign P1 on UnderexcLim2Simplified
   *
   * @param command AssignP1ToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignP1(AssignP1ToUnderexcLim2SimplifiedCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign P1 on UnderexcLim2Simplified
   *
   * @param command UnAssignP1FromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignP1(UnAssignP1FromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P1 on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q0 on UnderexcLim2Simplified
   *
   * @param command AssignQ0ToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignQ0(AssignQ0ToUnderexcLim2SimplifiedCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign Q0 on UnderexcLim2Simplified
   *
   * @param command UnAssignQ0FromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignQ0(UnAssignQ0FromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q0 on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q1 on UnderexcLim2Simplified
   *
   * @param command AssignQ1ToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignQ1(AssignQ1ToUnderexcLim2SimplifiedCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign Q1 on UnderexcLim2Simplified
   *
   * @param command UnAssignQ1FromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignQ1(UnAssignQ1FromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q1 on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimax on UnderexcLim2Simplified
   *
   * @param command AssignVuimaxToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignVuimax(AssignVuimaxToUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign Vuimax on UnderexcLim2Simplified
   *
   * @param command UnAssignVuimaxFromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignVuimax(UnAssignVuimaxFromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimax on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vuimin on UnderexcLim2Simplified
   *
   * @param command AssignVuiminToUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void assignVuimin(AssignVuiminToUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcLim2SimplifiedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    UnderexcLim2SimplifiedBusinessDelegate parentDelegate =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

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
   * unAssign Vuimin on UnderexcLim2Simplified
   *
   * @param command UnAssignVuiminFromUnderexcLim2SimplifiedCommand
   * @exception ProcessingException
   */
  public void unAssignVuimin(UnAssignVuiminFromUnderexcLim2SimplifiedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcLim2SimplifiedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vuimin on UnderexcLim2Simplified";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return UnderexcLim2Simplified
   */
  private UnderexcLim2Simplified load(UUID id) throws ProcessingException {
    underexcLim2Simplified =
        UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
            .getUnderexcLim2Simplified(new UnderexcLim2SimplifiedFetchOneSummary(id));
    return underexcLim2Simplified;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private UnderexcLim2Simplified underexcLim2Simplified = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLim2SimplifiedBusinessDelegate.class.getName());
}
