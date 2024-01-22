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
 * RatioTapChanger business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RatioTapChanger related services in the case of a
 *       RatioTapChanger business related service failing.
 *   <li>Exposes a simpler, uniform RatioTapChanger interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RatioTapChanger business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RatioTapChangerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RatioTapChangerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RatioTapChanger Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RatioTapChangerBusinessDelegate
   */
  public static RatioTapChangerBusinessDelegate getRatioTapChangerInstance() {
    return (new RatioTapChangerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRatioTapChanger(CreateRatioTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRatioTapChangerId() == null) command.setRatioTapChangerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRatioTapChangerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRatioTapChangerCommand of RatioTapChanger is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RatioTapChanger - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRatioTapChangerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRatioTapChanger(UpdateRatioTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRatioTapChangerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RatioTapChanger - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRatioTapChangerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRatioTapChangerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRatioTapChangerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RatioTapChanger using Id = " + command.getRatioTapChangerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RatioTapChanger via RatioTapChangerFetchOneSummary
   *
   * @param summary RatioTapChangerFetchOneSummary
   * @return RatioTapChangerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RatioTapChanger getRatioTapChanger(RatioTapChangerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RatioTapChangerFetchOneSummary arg cannot be null");

    RatioTapChanger entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RatioTapChanger
      // --------------------------------------
      CompletableFuture<RatioTapChanger> futureEntity =
          queryGateway.query(
              new FindRatioTapChangerQuery(
                  new LoadRatioTapChangerFilter(summary.getRatioTapChangerId())),
              ResponseTypes.instanceOf(RatioTapChanger.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RatioTapChanger with id " + summary.getRatioTapChangerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RatioTapChangers
   *
   * @return List<RatioTapChanger>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RatioTapChanger> getAllRatioTapChanger() throws ProcessingException {
    List<RatioTapChanger> list = null;

    try {
      CompletableFuture<List<RatioTapChanger>> futureList =
          queryGateway.query(
              new FindAllRatioTapChangerQuery(),
              ResponseTypes.multipleInstancesOf(RatioTapChanger.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RatioTapChanger";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign StepVoltageIncrement on RatioTapChanger
   *
   * @param command AssignStepVoltageIncrementToRatioTapChangerCommand
   * @exception ProcessingException
   */
  public void assignStepVoltageIncrement(AssignStepVoltageIncrementToRatioTapChangerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRatioTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    RatioTapChangerBusinessDelegate parentDelegate =
        RatioTapChangerBusinessDelegate.getRatioTapChangerInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign StepVoltageIncrement on RatioTapChanger
   *
   * @param command UnAssignStepVoltageIncrementFromRatioTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignStepVoltageIncrement(
      UnAssignStepVoltageIncrementFromRatioTapChangerCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StepVoltageIncrement on RatioTapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatioTapChanger on RatioTapChanger
   *
   * @param command AssignRatioTapChangerToRatioTapChangerCommand
   * @exception ProcessingException
   */
  public void assignRatioTapChanger(AssignRatioTapChangerToRatioTapChangerCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRatioTapChangerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RatioTapChangerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RatioTapChangerBusinessDelegate.getRatioTapChangerInstance();
    RatioTapChangerBusinessDelegate parentDelegate =
        RatioTapChangerBusinessDelegate.getRatioTapChangerInstance();
    UUID childId = command.getAssignment().getRatioTapChangerId();
    RatioTapChanger child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get RatioTapChanger using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatioTapChanger on RatioTapChanger
   *
   * @param command UnAssignRatioTapChangerFromRatioTapChangerCommand
   * @exception ProcessingException
   */
  public void unAssignRatioTapChanger(UnAssignRatioTapChangerFromRatioTapChangerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RatioTapChangerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatioTapChanger on RatioTapChanger";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return RatioTapChanger
   */
  private RatioTapChanger load(UUID id) throws ProcessingException {
    ratioTapChanger =
        RatioTapChangerBusinessDelegate.getRatioTapChangerInstance()
            .getRatioTapChanger(new RatioTapChangerFetchOneSummary(id));
    return ratioTapChanger;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RatioTapChanger ratioTapChanger = null;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerBusinessDelegate.class.getName());
}
