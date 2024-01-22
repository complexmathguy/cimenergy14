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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * WindType1or2UserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindType1or2UserDefined related services in the case of a
 *       WindType1or2UserDefined business related service failing.
 *   <li>Exposes a simpler, uniform WindType1or2UserDefined interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindType1or2UserDefined
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindType1or2UserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindType1or2UserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindType1or2UserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindType1or2UserDefinedBusinessDelegate
   */
  public static WindType1or2UserDefinedBusinessDelegate getWindType1or2UserDefinedInstance() {
    return (new WindType1or2UserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindType1or2UserDefined(
      CreateWindType1or2UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindType1or2UserDefinedId() == null)
        command.setWindType1or2UserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindType1or2UserDefinedCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindType1or2UserDefinedCommand of WindType1or2UserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindType1or2UserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindType1or2UserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindType1or2UserDefined(
      UpdateWindType1or2UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindType1or2UserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindType1or2UserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindType1or2UserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindType1or2UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindType1or2UserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindType1or2UserDefined using Id = "
              + command.getWindType1or2UserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindType1or2UserDefined via WindType1or2UserDefinedFetchOneSummary
   *
   * @param summary WindType1or2UserDefinedFetchOneSummary
   * @return WindType1or2UserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindType1or2UserDefined getWindType1or2UserDefined(
      WindType1or2UserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindType1or2UserDefinedFetchOneSummary arg cannot be null");

    WindType1or2UserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindType1or2UserDefined
      // --------------------------------------
      CompletableFuture<WindType1or2UserDefined> futureEntity =
          queryGateway.query(
              new FindWindType1or2UserDefinedQuery(
                  new LoadWindType1or2UserDefinedFilter(summary.getWindType1or2UserDefinedId())),
              ResponseTypes.instanceOf(WindType1or2UserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindType1or2UserDefined with id "
              + summary.getWindType1or2UserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindType1or2UserDefineds
   *
   * @return List<WindType1or2UserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindType1or2UserDefined> getAllWindType1or2UserDefined() throws ProcessingException {
    List<WindType1or2UserDefined> list = null;

    try {
      CompletableFuture<List<WindType1or2UserDefined>> futureList =
          queryGateway.query(
              new FindAllWindType1or2UserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(WindType1or2UserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindType1or2UserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on WindType1or2UserDefined
   *
   * @param command AssignProprietaryToWindType1or2UserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToWindType1or2UserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindType1or2UserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindType1or2UserDefinedBusinessDelegate parentDelegate =
        WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(command);

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
   * unAssign Proprietary on WindType1or2UserDefined
   *
   * @param command UnAssignProprietaryFromWindType1or2UserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(UnAssignProprietaryFromWindType1or2UserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindType1or2UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on WindType1or2UserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindType1or2UserDefined
   */
  private WindType1or2UserDefined load(UUID id) throws ProcessingException {
    windType1or2UserDefined =
        WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance()
            .getWindType1or2UserDefined(new WindType1or2UserDefinedFetchOneSummary(id));
    return windType1or2UserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindType1or2UserDefined windType1or2UserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindType1or2UserDefinedBusinessDelegate.class.getName());
}
