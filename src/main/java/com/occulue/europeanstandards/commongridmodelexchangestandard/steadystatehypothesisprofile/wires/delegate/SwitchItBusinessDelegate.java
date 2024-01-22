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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.validator.*;
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
 * SwitchIt business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SwitchIt related services in the case of a SwitchIt business
 *       related service failing.
 *   <li>Exposes a simpler, uniform SwitchIt interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SwitchIt business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SwitchItBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SwitchItBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SwitchIt Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SwitchItBusinessDelegate
   */
  public static SwitchItBusinessDelegate getSwitchItInstance() {
    return (new SwitchItBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSwitchIt(CreateSwitchItCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSwitchItId() == null) command.setSwitchItId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchItValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSwitchItCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSwitchItCommand of SwitchIt is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SwitchIt - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSwitchItCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSwitchIt(UpdateSwitchItCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SwitchItValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSwitchItCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SwitchIt - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSwitchItCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSwitchItCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchItValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSwitchItCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SwitchIt using Id = " + command.getSwitchItId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SwitchIt via SwitchItFetchOneSummary
   *
   * @param summary SwitchItFetchOneSummary
   * @return SwitchItFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SwitchIt getSwitchIt(SwitchItFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SwitchItFetchOneSummary arg cannot be null");

    SwitchIt entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SwitchItValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SwitchIt
      // --------------------------------------
      CompletableFuture<SwitchIt> futureEntity =
          queryGateway.query(
              new FindSwitchItQuery(new LoadSwitchItFilter(summary.getSwitchItId())),
              ResponseTypes.instanceOf(SwitchIt.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SwitchIt with id " + summary.getSwitchItId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SwitchIts
   *
   * @return List<SwitchIt>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SwitchIt> getAllSwitchIt() throws ProcessingException {
    List<SwitchIt> list = null;

    try {
      CompletableFuture<List<SwitchIt>> futureList =
          queryGateway.query(
              new FindAllSwitchItQuery(), ResponseTypes.multipleInstancesOf(SwitchIt.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SwitchIt";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Open on SwitchIt
   *
   * @param command AssignOpenToSwitchItCommand
   * @exception ProcessingException
   */
  public void assignOpen(AssignOpenToSwitchItCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSwitchItId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SwitchItBusinessDelegate parentDelegate = SwitchItBusinessDelegate.getSwitchItInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SwitchItValidator.getInstance().validate(command);

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
   * unAssign Open on SwitchIt
   *
   * @param command UnAssignOpenFromSwitchItCommand
   * @exception ProcessingException
   */
  public void unAssignOpen(UnAssignOpenFromSwitchItCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchItValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Open on SwitchIt";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SwitchIt
   */
  private SwitchIt load(UUID id) throws ProcessingException {
    switchIt =
        SwitchItBusinessDelegate.getSwitchItInstance().getSwitchIt(new SwitchItFetchOneSummary(id));
    return switchIt;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SwitchIt switchIt = null;
  private static final Logger LOGGER = Logger.getLogger(SwitchItBusinessDelegate.class.getName());
}
