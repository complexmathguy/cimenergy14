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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator.*;
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
 * LoadGenericNonLinear business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of LoadGenericNonLinear related services in the case of a
 *       LoadGenericNonLinear business related service failing.
 *   <li>Exposes a simpler, uniform LoadGenericNonLinear interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill LoadGenericNonLinear
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LoadGenericNonLinearBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LoadGenericNonLinearBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * LoadGenericNonLinear Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LoadGenericNonLinearBusinessDelegate
   */
  public static LoadGenericNonLinearBusinessDelegate getLoadGenericNonLinearInstance() {
    return (new LoadGenericNonLinearBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLoadGenericNonLinear(
      CreateLoadGenericNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLoadGenericNonLinearId() == null)
        command.setLoadGenericNonLinearId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLoadGenericNonLinearCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLoadGenericNonLinearCommand of LoadGenericNonLinear is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create LoadGenericNonLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLoadGenericNonLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLoadGenericNonLinear(
      UpdateLoadGenericNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLoadGenericNonLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save LoadGenericNonLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLoadGenericNonLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLoadGenericNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLoadGenericNonLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete LoadGenericNonLinear using Id = " + command.getLoadGenericNonLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the LoadGenericNonLinear via LoadGenericNonLinearFetchOneSummary
   *
   * @param summary LoadGenericNonLinearFetchOneSummary
   * @return LoadGenericNonLinearFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public LoadGenericNonLinear getLoadGenericNonLinear(LoadGenericNonLinearFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("LoadGenericNonLinearFetchOneSummary arg cannot be null");

    LoadGenericNonLinear entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a LoadGenericNonLinear
      // --------------------------------------
      CompletableFuture<LoadGenericNonLinear> futureEntity =
          queryGateway.query(
              new FindLoadGenericNonLinearQuery(
                  new LoadLoadGenericNonLinearFilter(summary.getLoadGenericNonLinearId())),
              ResponseTypes.instanceOf(LoadGenericNonLinear.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate LoadGenericNonLinear with id " + summary.getLoadGenericNonLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all LoadGenericNonLinears
   *
   * @return List<LoadGenericNonLinear>
   * @exception ProcessingException Thrown if any problems
   */
  public List<LoadGenericNonLinear> getAllLoadGenericNonLinear() throws ProcessingException {
    List<LoadGenericNonLinear> list = null;

    try {
      CompletableFuture<List<LoadGenericNonLinear>> futureList =
          queryGateway.query(
              new FindAllLoadGenericNonLinearQuery(),
              ResponseTypes.multipleInstancesOf(LoadGenericNonLinear.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Bs on LoadGenericNonLinear
   *
   * @param command AssignBsToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignBs(AssignBsToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Bs on LoadGenericNonLinear
   *
   * @param command UnAssignBsFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignBs(UnAssignBsFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bs on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Bt on LoadGenericNonLinear
   *
   * @param command AssignBtToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignBt(AssignBtToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Bt on LoadGenericNonLinear
   *
   * @param command UnAssignBtFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignBt(UnAssignBtFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bt on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ls on LoadGenericNonLinear
   *
   * @param command AssignLsToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignLs(AssignLsToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Ls on LoadGenericNonLinear
   *
   * @param command UnAssignLsFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignLs(UnAssignLsFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ls on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lt on LoadGenericNonLinear
   *
   * @param command AssignLtToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignLt(AssignLtToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Lt on LoadGenericNonLinear
   *
   * @param command UnAssignLtFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignLt(UnAssignLtFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lt on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pt on LoadGenericNonLinear
   *
   * @param command AssignPtToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignPt(AssignPtToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Pt on LoadGenericNonLinear
   *
   * @param command UnAssignPtFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignPt(UnAssignPtFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pt on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Qt on LoadGenericNonLinear
   *
   * @param command AssignQtToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignQt(AssignQtToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Qt on LoadGenericNonLinear
   *
   * @param command UnAssignQtFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignQt(UnAssignQtFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Qt on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tp on LoadGenericNonLinear
   *
   * @param command AssignTpToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignTp(AssignTpToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Tp on LoadGenericNonLinear
   *
   * @param command UnAssignTpFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignTp(UnAssignTpFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tp on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tq on LoadGenericNonLinear
   *
   * @param command AssignTqToLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void assignTq(AssignTqToLoadGenericNonLinearCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadGenericNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadGenericNonLinearBusinessDelegate parentDelegate =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

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
   * unAssign Tq on LoadGenericNonLinear
   *
   * @param command UnAssignTqFromLoadGenericNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignTq(UnAssignTqFromLoadGenericNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadGenericNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tq on LoadGenericNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return LoadGenericNonLinear
   */
  private LoadGenericNonLinear load(UUID id) throws ProcessingException {
    loadGenericNonLinear =
        LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance()
            .getLoadGenericNonLinear(new LoadGenericNonLinearFetchOneSummary(id));
    return loadGenericNonLinear;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private LoadGenericNonLinear loadGenericNonLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadGenericNonLinearBusinessDelegate.class.getName());
}
